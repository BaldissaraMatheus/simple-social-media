package br.com.uff.socialmedia.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.uff.socialmedia.model.User;
import br.com.uff.socialmedia.model.dao.PostDao;
import br.com.uff.socialmedia.model.dao.UserDao;

/**
 * Servlet implementation class ExcluiPostServlet
 */
@WebServlet("/excluiPost")
public class ExcluiPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String URL_BASE = "/socialmedia";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcluiPostServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		PostDao postDao = new PostDao();
	    UserDao userDao = new UserDao();	    
	    if (sessao.getAttribute("usuario") != null) {
	    	User usuario = (User) sessao.getAttribute("usuario");
	    	int postId = Integer.parseInt(request.getParameter("postId"));
	    	postDao.delete(postId);
			userDao.update(usuario.getEmail(), usuario);
	    }
		response.sendRedirect(URL_BASE + "/dashboard");
	}

}
