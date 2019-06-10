package br.com.uff.socialmedia.model.dao;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.uff.socialmedia.conector.Conector;
import br.com.uff.socialmedia.model.User;

public class UserLogin {
	public static User Login(String email, String password) {
		Connection con;
		User usuario = new User();
		UserDao dao = new UserDao();

		usuario = dao.get(email);
		System.out.println(usuario.getUsername()+usuario.getName()+usuario.getIcon().getNome()+usuario.getPassword());
		
		if (usuario != null && usuario.getPassword().equals(password)) {
			return usuario;
				
		} else {
			System.out.println("Usuário não encontrado");
		}
		
		return null;
	}
	
}
