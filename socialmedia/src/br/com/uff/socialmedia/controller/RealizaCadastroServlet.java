package br.com.uff.socialmedia.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.uff.socialmedia.model.User;
import br.com.uff.socialmedia.model.dao.UserDao;

@WebServlet("/realizaCadastro")
public class RealizaCadastroServlet extends HttpServlet {
	
	UserDao userDao = new UserDao();
	User usuario = new User();

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		usuario.setUsername(req.getParameter("username")); 
		usuario.setName(req.getParameter("name"));
		usuario.setEmail(req.getParameter("email"));
		usuario.setIcon(req.getParameter("icon"));
		
		userDao.save(usuario);
		
		req.setAttribute("username", usuario.getUsername());
		req.setAttribute("name", usuario.getName());
		req.setAttribute("email", usuario.getEmail());
		req.setAttribute("iconName", usuario.getIcon().getNome());
		req.setAttribute("iconEndereco", usuario.getIcon().getEndereco());
		
		RequestDispatcher rd = req.getRequestDispatcher(
			"/realizaCadastro.jsp?usuario=" + usuario.getName()
			+ "&name=" + usuario.getName()
			+ "&email=" + usuario.getEmail()
			+ "&iconName=" + usuario.getIcon().getNome()
			+ "&iconEndereco=" + usuario.getIcon().getEndereco()
		);
		
		rd.forward(req, res);
	}

}
