package br.com.uff.socialmedia.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.uff.socialmedia.model.User;
import br.com.uff.socialmedia.model.dao.UserDao;

@WebServlet("/realizaCadastro")
public class RealizaCadastroServlet extends HttpServlet {
	
	UserDao userDao = new UserDao();
	User usuario = new User();

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		usuario.setUsername(req.getParameter("username")); 
		usuario.setPassword(req.getParameter("password"));
		usuario.setName(req.getParameter("name"));
		usuario.setEmail(req.getParameter("email"));
		usuario.setIcon(req.getParameter("icon"));
		
		userDao.save(usuario);
		
		HttpSession sessao = req.getSession(true);
		sessao.setAttribute("username", usuario.getUsername());
		sessao.setAttribute("name", usuario.getName());
		sessao.setAttribute("email", usuario.getEmail());
		sessao.setAttribute("iconName", usuario.getIcon().getNome());
		sessao.setAttribute("icon", usuario.getIcon().getNome());
		
		res.sendRedirect("dashboard");
	}

}
