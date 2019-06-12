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
import br.com.uff.socialmedia.model.dao.UserDao;

@WebServlet("/criaReply")
public class CriaReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String URL_BASE = "/socialmedia";

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession sessao = req.getSession();
		UserDao userDao = new UserDao();
		PostDao postDao = new PostDao();

		if (sessao.getAttribute("usuario") != null && !req.getParameter("content").equals("")) {
			User usuario = (User) sessao.getAttribute("usuario");
			Post origin = postDao.get(Integer.parseInt(req.getParameter("postId")));
			String replyContent = req.getParameter("content");

			usuario.createReply(origin, replyContent);
			postDao.update(origin.getId(), origin);
			userDao.update(usuario.getEmail(), usuario);
		}

		res.sendRedirect(URL_BASE + "/dashboard");
	}
}