package br.com.uff.socialmedia.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.uff.socialmedia.model.User;
import br.com.uff.socialmedia.model.dao.UserDao;

/**
 * Servlet implementation class RealizaRedefinicaoSenhaServlet
 */
@WebServlet("/realizaRedefinicaoSenha")
public class RealizaRedefinicaoSenhaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao userDao = new UserDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RealizaRedefinicaoSenhaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		User usuario = new User();
		
		usuario.setEmail(req.getParameter("email"));
		usuario.setPassword(req.getParameter("novasenha"));
		userDao.resetPassword(usuario);
		res.sendRedirect("login");
		
	}

}
