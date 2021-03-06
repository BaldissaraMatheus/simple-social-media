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

	public User() {
		this.posts = new ArrayList<Post>();
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
		Reply reply = new Reply(origin);
		reply.setContent(content);
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

}
