package br.com.uff.socialmedia.model;

import java.util.ArrayList;
import java.util.List;

public class User {
	private String username;
	private String email;
	private String password;
	private List<Post> posts;
	private String name;
	private Icon icon;
	private List<Post> likedPosts;

	public User() {
		this.posts = new ArrayList<Post>();
		this.likedPosts = new ArrayList<Post>();		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public List<Post> getLikedPosts() {
		return likedPosts;
	}

	public void setLikedPosts(List<Post> likedPosts) {
		this.likedPosts = likedPosts;
	}
	
	public Icon getIcon() {
		return icon;
	}
	
	public void setIcon(String nome) {
		this.icon = Icon.findIconByNome(nome);
	}
		
	public Post createPost(String content) {
		Post post = new Post(content);
		post.setOwner(this);
		this.posts.add(post);
		return post;
	}
	
	public Reply createReply(Post origin, String content) {
		Reply reply = new Reply(origin, content);
		reply.setOwner(this);
		origin.addReply(reply);
		return reply;
	}
	
	public Post updatePost(Post post, String content) {		
		int index = posts.indexOf(post);
		post.setContent(content);
		this.updatePost(index, post);
		return post;
	}

	private void updatePost(int index, Post post) {
		this.posts.remove(index);
		this.posts.add(post);
	}
	
	public void deletePost(Post post) {
		this.posts.remove(post);
	}
	
	public Post likePost(Post post) {
		if (this.likedPosts.contains(post)) {
			this.likedPosts.remove(post);
			return null;
			
		} else {
			this.likedPosts.add(post);
			return post;
		}
	}
	
	public Post getLikedPostById(int id) {
		for (Post post : likedPosts) {
			if (post.getId() == id) return post;
		}
		return null;
	}
	
	public void removeLikedPost(Post post) {
		for (Post likedPost : likedPosts) {
			if (likedPost.equals(post)) likedPosts.remove(likedPosts.indexOf(post));
			return;
		}
	}
	
	public void addLikedPost(Post post) {
		likedPosts.add(post);
	}
	
}
