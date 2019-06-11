package br.com.uff.socialmedia.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.uff.socialmedia.conector.Conector;
import br.com.uff.socialmedia.model.Post;

public class PostDao implements Dao<Post> {

	private static List<Post> posts = new ArrayList<Post>();
	private static int POST_ID = 0;

	@Override
	public void save(Post post) {
		Connection con = Conector.getConnection();
		PreparedStatement st;
		try {
			st = con.prepareStatement("insert into post values(null,?,?)");
			st.setString(1, post.getContent());
			st.setString(2, post.getOwner().getUsername());
			// post.setId(POST_ID);
			// POST_ID += 1;
			st.executeUpdate();
			// posts.add(post);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		Connection con = Conector.getConnection();
		PreparedStatement st;
		try {
			st = con.prepareStatement("delete from post where idpost=?");
			st.setInt(1, id);
			st.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} /*
			 * for (Post post : posts) { System.out.println(post.getId()); if (post.getId()
			 * == id) { posts.remove(post); return; }
			 * 
			 * }
			 */
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
		Post post;
		Connection con = Conector.getConnection();
		Statement st;
		ResultSet rs;
		try {
			st = con.createStatement();
			rs = st.executeQuery("select content, owner_username where idpost='" + id + "'");
			if (rs.next()) {
				String conteudo = rs.getString(1);
				post = new Post(conteudo);
				String owner = rs.getString(2);
				post.setOwner(owner);
				con.close();
				return post;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} /*
			 * for (Post post : posts) { if (post.getId() == id) return post; }
			 */
		return null;
	}

	public List<Post> getAll() {
		Connection con;
		try {
			posts.clear();
			con = Conector.getConnection();
			PreparedStatement st = con.prepareStatement("select * from post");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Post post = new Post(rs.getString(2));
				post.setOwner(rs.getString(3));
				posts.add(post);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return posts;
	}

	@Override
	public void lista() {
		for (Post post : posts)
			System.out.println(post.getContent());
	}

}
