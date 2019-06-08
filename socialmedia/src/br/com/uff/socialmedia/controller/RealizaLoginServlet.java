package br.com.uff.socialmedia.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.uff.socialmedia.model.dao.UserLogin;

/**
 * Servlet implementation class RealizaLogin
 */
@WebServlet("/realizaLogin")
public class RealizaLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String URL_BASE = "/socialmedia";
       
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		if (UserLogin.Login(email, password) != null) {
			req.setAttribute("email", email);
			RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
			rd.forward(req, res);
			
		} else {
			res.sendRedirect(URL_BASE + "/login?err=algo-de-errado-nao-esta-certo");
		}
		
		
	}

}
