package br.com.uff.socialmedia.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(urlPatterns = "/cadastra")
public class CadastraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest req, ServletResponse res) throws IOException, ServletException {
		if (req.getParameter("err") != null && req.getParameter("err").equals("email-ja-cadastrado")) {
			req.setAttribute("err", "Email já cadastrado");
		}
		
		if (req.getParameter("err") != null && req.getParameter("err").equals("username-ja-cadastrado")) {
			req.setAttribute("err", "Username já cadastrado");
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("/cadastra.jsp");
		rd.forward(req, res);
	}
}
