package br.com.uff.socialmedia.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import br.com.uff.socialmedia.model.User;
import br.com.uff.socialmedia.model.dao.Dao;

@WebServlet(urlPatterns="/cadastra")
public class CadastraServlet extends HttpServlet{
	
	private static Dao<User> UserDao;
	
	User usuario = new User();
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws IOException, ServletException {

		String nome = req.getParameter("nome");		
		usuario.setName(nome);
		
		UserDao.save(usuario);
		
	    RequestDispatcher rd = req.getRequestDispatcher("/cadastra.jsp");
	    req.setAttribute("nome", UserDao.get(0).getName());
	    rd.forward(req, res);
		
	}
	
}
