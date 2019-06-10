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

@WebServlet("/likePost")
public class LikePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String URL_BASE = "/socialmedia";
       
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PostDao postDao = new PostDao();
		UserDao userDao = new UserDao();
		
		HttpSession sessao = req.getSession();
		User usuario = (User)sessao.getAttribute("usuario");
		
		int id = Integer.parseInt(req.getParameter("post"));
		Post post = postDao.get(id);
		
		if (usuario != null && post != null) {
			
			if (usuario.getLikedPostById(id) == null) {
				usuario.addLikedPost(post);
			
			} else {
				usuario.removeLikedPost(post);
			}
		}
		
		res.sendRedirect(URL_BASE + "/dashboard");
	}

}
