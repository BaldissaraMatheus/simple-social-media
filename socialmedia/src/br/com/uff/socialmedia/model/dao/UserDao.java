package br.com.uff.socialmedia.model.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.uff.socialmedia.model.User;

public class UserDao implements Dao<User> {

	private static List<User> usuarios = new ArrayList<User>();
	
	static {
//		User usuario = new User();
//		usuario.setUsername("teste");
//		usuario.setEmail("teste@uff.br");
//		usuario.setIcon("toph");
//		usuario.setName("teste");
//		usuario.setPassword("123");
//		
//		PostDao dao = new PostDao();
//		Post post = usuario.createPost("Água tem memória!!!");
//		usuario.createReply(post, "Abortar eh muito bom");
//		usuario.createReply(post, "#UnidosPelaLigaNacionalDeHomeopatia");
//		dao.save(post);
//		int i = 0;
//		
//		for (Reply reply : dao.get(post.getId()).getReplies()) {			
//			System.out.println(reply.getContent() + i);
//			i += 1;
//		}
//		
//		usuarios.add(usuario);
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
			if (user.getEmail().equals(email)) return user;
		}
		return null;
	}
	
	public User update(String email, User usuario) {
		for (User user : usuarios) {
			if (user.getEmail().equals(email)) {
				delete(usuarios.indexOf(usuario));
				usuarios.add(usuario);
				return usuario;
			};
		}
		return null;
	}
}
