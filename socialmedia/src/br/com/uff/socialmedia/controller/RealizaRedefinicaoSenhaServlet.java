package br.com.uff.socialmedia.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.uff.socialmedia.model.User;
import br.com.uff.socialmedia.model.dao.UserDao;

@WebServlet("/realizaRedefinicaoSenha")
public class RealizaRedefinicaoSenhaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao userDao = new UserDao();

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		User usuario = new User();
		
		usuario.setEmail(req.getParameter("email"));
		usuario.setPassword(req.getParameter("novaSenha"));
		
		if (userDao.getByEmail(usuario.getEmail()) == null) {
			res.sendRedirect("redefine-senha?err=usuario-nao-encontrado");	
			return;
		}
		
		userDao.resetPassword(usuario);
		res.sendRedirect("login");
	}
}
