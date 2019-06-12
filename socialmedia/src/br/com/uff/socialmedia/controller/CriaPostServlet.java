package br.com.uff.socialmedia.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.uff.socialmedia.model.Post;
import br.com.uff.socialmedia.model.User;
import br.com.uff.socialmedia.model.dao.PostDao;

@WebServlet("/criaPost")
public class CriaPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String URL_BASE = "/socialmedia";

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession sessao = req.getSession();
		PostDao postDao = new PostDao();

		if (sessao.getAttribute("usuario") != null && !req.getParameter("content").equals("")) {
			User usuario = (User) sessao.getAttribute("usuario");
			Post post = usuario.createPost((String) req.getParameter("content"));
			postDao.save(post);
		}

		res.sendRedirect(URL_BASE + "/dashboard");
	}

}
