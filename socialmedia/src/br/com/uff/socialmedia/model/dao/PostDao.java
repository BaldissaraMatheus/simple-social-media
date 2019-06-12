package br.com.uff.socialmedia.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.uff.socialmedia.controller.connector.Connector;
import br.com.uff.socialmedia.model.Post;
import br.com.uff.socialmedia.model.User;

public class PostDao implements Dao<Post> {

	@Override
	public void save(Post post) {
		Connection con = Connector.getConnection();
		
		try {
			PreparedStatement st = con.prepareStatement("insert into post(user_username, content) values(?, ?)");
			st.setString(1, post.getOwner().getUsername());
			st.setString(2, post.getContent());
			st.executeUpdate();

			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void delete(int id) {

		Connection con = Connector.getConnection();

		try {
			PreparedStatement st = con.prepareStatement("delete from post where id=?");
			st.setInt(1, id);
			st.executeUpdate();	
			
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	public void update(int id, Post post) {
		Connection con = Connector.getConnection();
		
		try {
			PreparedStatement st1 = con.prepareStatement("delete from post where id=?");
			st1.setInt(1, id);
			st1.executeUpdate();
			
			PreparedStatement st = con.prepareStatement("insert into post(user_username, content) values(?, ?)");
			st.setString(1, post.getOwner().getUsername());
			st.setString(2, post.getContent());
			st.executeUpdate();

			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	public Post get(int id) {

		Connection con = Connector.getConnection();
		UserDao userDao = new UserDao();
		Post post = null;

		try {
			PreparedStatement st = con.prepareStatement("select * from post where id=?");
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			
			if (rs.next()) {
				User user = new User();
				user = userDao.getByUsername(rs.getString("user_username"));
				
				post = new Post();
				post.setOwner(user);
				post.setContent(rs.getString("content"));
				con.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return post;	
		
	}
		
	
	public List<Post> getAll() {
		Connection con = Connector.getConnection();
		UserDao userDao = new UserDao();
		List<Post> posts = new ArrayList<Post>();
		

		try {
			PreparedStatement st = con.prepareStatement("select * from post");
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				User user = new User();
				user = userDao.getByUsername(rs.getString("user_username"));
				
				Post post = new Post();
				post.setOwner(user);
				post.setContent(rs.getString("content"));
				posts.add(post);
			}
			
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return posts;	
	}

}
