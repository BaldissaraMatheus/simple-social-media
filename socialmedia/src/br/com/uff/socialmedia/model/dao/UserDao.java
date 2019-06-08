package br.com.uff.socialmedia.model.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.uff.socialmedia.model.User;

public class UserDao implements Dao<User> {

	private static List<User> usuarios = new ArrayList<User>();
	
	static {
		User usuario = new User();
		usuario.setUsername("samir");
		usuario.setEmail("samir@uff.br");
		usuario.setIcon("toph");
		usuario.setName("Samir");
		usuario.setPassword("123");
		usuarios.add(usuario);
	}
	
	@Override
	public void save(User user) {
		usuarios.add(user);		
	}

	@Override
	public void delete(int index) {
		usuarios.remove(index);
		
	}

	@Override
	public void lista() {
		usuarios.forEach(usuario -> {
			System.out.println(usuario);
		});
	}

	public User get(String email) {
		
		for (User user : usuarios) {
//			System.out.println(user.getEmail());
			if (user.getEmail().equals(email)) return user;
		}
		return null;
	}

}
