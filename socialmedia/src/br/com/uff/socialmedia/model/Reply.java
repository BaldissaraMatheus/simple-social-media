package br.com.uff.socialmedia.model;

public class Reply extends Post {

	private Post origin;

	public Post getOrigin() {
		return origin;
	}

	public void setOrigin(Post origin) {
		this.origin = origin;
	}

	public Reply(Post post) {
		super();
		this.setOrigin(post);
	}

}
