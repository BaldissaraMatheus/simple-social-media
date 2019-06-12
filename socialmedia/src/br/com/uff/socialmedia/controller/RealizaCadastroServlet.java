package br.com.uff.socialmedia.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.uff.socialmedia.model.User;
import br.com.uff.socialmedia.model.dao.UserDao;

@WebServlet("/realizaCadastro")
public class RealizaCadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UserDao userDao = new UserDao();

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		User usuario = new User();

		usuario.setUsername(req.getParameter("username"));
		usuario.setPassword(req.getParameter("password"));
		usuario.setName(req.getParameter("name"));
		usuario.setEmail(req.getParameter("email"));
		usuario.setIcon(req.getParameter("icon"));

		if (userDao.getByEmail(usuario.getEmail()) != null) {
			res.sendRedirect("cadastra?err=email-ja-cadastrado");
			return;
		}
		
		if (userDao.getByUsername(usuario.getUsername()) != null) {
			res.sendRedirect("cadastra?err=username-ja-cadastrado");
			return;
		}
		
		userDao.save(usuario);
		res.sendRedirect("dashboard");
	}

}
