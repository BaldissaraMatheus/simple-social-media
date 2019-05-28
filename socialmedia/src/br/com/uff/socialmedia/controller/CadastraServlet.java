package br.com.uff.socialmedia.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import br.com.uff.socialmedia.model.User;
import br.com.uff.socialmedia.model.dao.UserDao;

@WebServlet(urlPatterns="/cadastra")
public class CadastraServlet extends HttpServlet {
	
	UserDao userDao = new UserDao();
	
	User usuario = new User();
	
	// TODO: Criar um servlet e jsp para RealizaCadastro que faz todo o processo de cadastro em doPost
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws IOException, ServletException {
		
//		usuario.setName("qualquer coisa"); 
//		userDao.save(usuario);
//		req.setAttribute("usuario", usuario.getName()); 
//		RequestDispatcher rd = req.getRequestDispatcher("/cadastra.jsp?usuario=" + usuario.getName());
//		rd.forward(req, res);
		
	}
	
}
