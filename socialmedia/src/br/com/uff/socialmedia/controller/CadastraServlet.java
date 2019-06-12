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

	@Override
	public void service(ServletRequest req, ServletResponse res) throws IOException, ServletException {
		RequestDispatcher rd = req.getRequestDispatcher("/cadastra.jsp");
		rd.forward(req, res);
	}
}
