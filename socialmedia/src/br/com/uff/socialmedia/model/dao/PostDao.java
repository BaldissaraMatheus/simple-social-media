package br.com.uff.socialmedia.model.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.uff.socialmedia.model.Post;

public class PostDao implements Dao<Post> {

	private static List<Post> posts = new ArrayList<Post>();
	private static int POST_ID = 0;

	@Override
	public void save(Post post) {
		post.setId(POST_ID);
		POST_ID += 1;
		posts.add(post);
	}

	@Override
	public void delete(int id) {
		for (Post post : posts) {
			System.out.println(post.getId());
			if (post.getId() == id) {
				posts.remove(post);
				return;
			}
				
		}
	}
	
	public void update(int id, Post newPost) {
		for (Post post : posts) {
			if (post.getId() == id) {
				posts.remove(posts.indexOf(post));
				posts.add(newPost);
			}
		}
	}

	public Post get(int id) {
		for (Post post : posts) {
			if (post.getId() == id)
				return post;
		}

		return null;
	}

	public List<Post> getAll() {
		return posts;
	}

	@Override
	public void lista() {
		for (Post post : posts)
			System.out.println(post.getContent());
	}

}
