package br.com.uff.socialmedia.model;

import java.util.HashMap;
import java.util.List;

public class User {
	private String username;
	private String email;
	private List<Post> posts;
	private String name;
	private HashMap<String, String> icon;
	private List<Post> likedPosts;

	public User() {}

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HashMap<String, String> getIcon() {
		return icon;
	}

	public void setIcon(HashMap<String, String> icon) {
		this.icon = icon;
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
	
	public Post createPost(String content) {
		Post post = new Post(content);
		this.posts.add(post);
		return post;
	}
	
	public Reply createReply(Post origin, String content) {
		Reply reply = new Reply(origin, content);
		this.posts.add(reply);
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
	
}
