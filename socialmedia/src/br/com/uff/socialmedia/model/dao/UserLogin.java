package br.com.uff.socialmedia.model.dao;

import java.sql.Connection;

import br.com.uff.socialmedia.model.User;

public class UserLogin {
	
	public static User Login(String email, String password) {
		Connection con;
		UserDao dao = new UserDao();
		User usuario = dao.getByEmail(email);

		if (usuario != null && usuario.getPassword().equals(password)) {
			return usuario;
		}

		return null;
	}

}
