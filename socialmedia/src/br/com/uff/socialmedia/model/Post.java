package br.com.uff.socialmedia.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Post {
	private int id;
	private String content;
	private LocalDate createdDate;
	private Integer likes;
	private List<Reply> replies;
	private User owner;
	
	public Post() {
		this.replies = new ArrayList<Reply>();
	}
	
	public Post(String content) {
		this.content = content;
		this.replies = new ArrayList<Reply>();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	public List<Reply> getReplies() {
		return replies;
	}

	public void setReplies(List<Reply> replies) {
		this.replies = replies;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public void addReply(Reply reply) {
		this.replies.add(reply);
	}
	
}
