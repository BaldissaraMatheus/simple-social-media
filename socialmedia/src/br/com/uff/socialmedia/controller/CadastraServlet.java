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
	
	private UserDao userDao;
	
	User usuario = new User();
	
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws IOException, ServletException {
		RequestDispatcher rd = req.getRequestDispatcher("/cadastra.jsp");
		rd.forward(req, res);
	}
	
	
	public void doGet(ServletRequest req, ServletResponse res) throws IOException, ServletException {
	    RequestDispatcher rd = req.getRequestDispatcher("/cadastra.jsp");
	    String nome = req.getParameter("nome");
	    req.setAttribute("nome", nome);
	    rd.forward(req, res);
	}
	
	// TODO: Criar método privado (ou classe?) de cadastro de usuário e chamar dentro do doPost
	public void doPost(ServletRequest req, ServletResponse res) throws IOException, ServletException {
		RequestDispatcher rd = req.getRequestDispatcher("/cadastra.jsp");
		rd.forward(req, res);
	
		
		
//		String nome = req.getParameter("nome");		
//		usuario.setName(nome);
//		
//		this.userDao.save(usuario);
//		
//	    RequestDispatcher rd = req.getRequestDispatcher("/cadastra.jsp");
//	    req.setAttribute("nome", nome);
//	    rd.forward(req, res);
		
	}
	
}
