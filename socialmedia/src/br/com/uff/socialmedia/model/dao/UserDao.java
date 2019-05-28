package br.com.uff.socialmedia.model.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.uff.socialmedia.model.User;

public class UserDao implements Dao<User> {

	private static List<User> usuarios = new ArrayList<User>();
	
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

	@Override
	public User get(int index) {
		return usuarios.get(index);
	}

}
