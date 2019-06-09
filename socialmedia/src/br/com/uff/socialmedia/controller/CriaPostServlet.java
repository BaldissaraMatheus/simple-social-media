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

@WebServlet("/criaPost")
public class CriaPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String URL_BASE = "/socialmedia";
       
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession sessao = req.getSession();
		UserDao userDao = new UserDao();
		PostDao postDao = new PostDao();
		
		if (sessao.getAttribute("email") != null && !req.getParameter("content").equals("")) {
			String email = (String) sessao.getAttribute("email");
			User usuario = userDao.get(email);
			Post post = usuario.createPost((String)req.getParameter("content"));
			postDao.save(post);
			userDao.update(email, usuario);
			
		} else {
			System.out.println("nope");
		}
		
		res.sendRedirect(URL_BASE + "/dashboard");
	}

}
