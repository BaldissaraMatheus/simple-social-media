package br.com.uff.socialmedia.model.dao;

import br.com.uff.socialmedia.model.User;

public class UserLogin {
	
	public static User Login(String email, String password) {
		UserDao dao = new UserDao();
		User usuario = dao.getByEmail(email);

		return (usuario != null && usuario.getPassword().equals(password)) ? usuario : null;
	}

}
