package br.com.uff.socialmedia.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/redefine-senha")
public class RedefinicaoSenhaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    @Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	if (req.getParameter("err") != null && req.getParameter("err").equals("usuario-nao-encontrado")) {
    		req.setAttribute("err", "Email não cadastrado");
    	}
		RequestDispatcher rd = req.getRequestDispatcher("/redefinicao-senha.jsp");
		rd.forward(req, res);
	}

}
