package br.com.uff.socialmedia.model;

import java.time.LocalDate;

public class Post {
	private Long id;
	private String content;
	private LocalDate createdDate;
	private Integer likes;
	private Reply[] replies;
	private User owner;
	
	public Post(String content) {
		this.content = content;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Reply[] getReplies() {
		return replies;
	}

	public void setReplies(Reply[] replies) {
		this.replies = replies;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

}
