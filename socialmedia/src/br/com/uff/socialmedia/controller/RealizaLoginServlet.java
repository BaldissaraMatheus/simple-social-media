package br.com.uff.socialmedia.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.uff.socialmedia.model.User;
import br.com.uff.socialmedia.model.dao.UserLogin;

@WebServlet("/realizaLogin")
public class RealizaLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String URL_BASE = "/socialmedia";

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");

		User usuario = UserLogin.Login(email, password);

		if (usuario != null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("usuario", usuario);

			res.sendRedirect(URL_BASE + "/dashboard");

		} else {
			res.sendRedirect(URL_BASE + "/login?err=algo-de-errado-nao-esta-certo");
		}
	}
}
