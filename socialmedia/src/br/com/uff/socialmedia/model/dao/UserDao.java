package br.com.uff.socialmedia.model.dao;

import java.util.List;

import br.com.uff.socialmedia.model.User;

public class UserDao implements Dao<User> {

	private List<User> usuarios;
	
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
		this.usuarios.forEach(usuario -> {
			System.out.println(usuario);
		});
	}

	@Override
	public User get(int index) {
		return this.usuarios.get(index);
	}

}
