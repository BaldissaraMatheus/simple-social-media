package br.com.uff.socialmedia.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.uff.socialmedia.model.dao.PostDao;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String URL_BASE = "/socialmedia";
       
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession sessao = req.getSession();
		PostDao dao = new PostDao();
		
		if (sessao.getAttribute("username") != null) {
			req.setAttribute("posts", dao.getAll());
						
			RequestDispatcher rd = req.getRequestDispatcher("/dashboard.jsp");
			rd.forward(req, res);
			
		} else {
			res.sendRedirect(URL_BASE + "/login");
		}
	}

}
