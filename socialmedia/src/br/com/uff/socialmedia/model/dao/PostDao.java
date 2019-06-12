package br.com.uff.socialmedia.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.uff.socialmedia.controller.connector.Connector;
import br.com.uff.socialmedia.model.Post;
import br.com.uff.socialmedia.model.Reply;
import br.com.uff.socialmedia.model.User;

public class PostDao {

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
				post.setId(rs.getInt("id"));
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
			PreparedStatement ps = con.prepareStatement("select * from post");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				User user = new User();
				user = userDao.getByUsername(rs.getString("user_username"));
				
				Post post = new Post();
				post.setId(rs.getInt("id"));
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

	public List<Post> getLikedPosts(User user) {
		Connection con = Connector.getConnection();
		List<Post> posts = new ArrayList<Post>();
		
		try {
			PreparedStatement ps = con.prepareStatement("select * from likedPost where user_username = ?");
			ps.setString(1, user.getUsername());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Post post = new Post();
				post = get(Integer.parseInt(rs.getString("post_id")));
				posts.add(post);
				con.close();
			}
			
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return posts;	
	}
	
	public boolean verificaSeUsuarioCurtiu(User user, int idPost) {
		Connection con = Connector.getConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement("select * from likedPost where user_username = ? and post_id = ?");
			ps.setString(1, user.getUsername());
			ps.setInt(2, idPost);
			ResultSet rs = ps.executeQuery();

			con.close();
			
			return (rs.next());
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public void createReply(Reply reply) {
		Connection con = Connector.getConnection();
		
		try {
			PreparedStatement st = con.prepareStatement("insert into reply(user_username, post_id, content) values(?, ?, ?)");
			st.setString(1, reply.getOwner().getUsername());
			st.setInt(2, reply.getOrigin().getId());
			st.setString(3, reply.getContent());
			st.executeUpdate();

			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<Reply> getReplies(Post post) {
		Connection con = Connector.getConnection();
		UserDao userDao = new UserDao();
		List<Reply> replies = new ArrayList<Reply>();
		
		try {
			PreparedStatement st = con.prepareStatement("select * from reply where post_id = ?");
			st.setInt(1, post.getId());
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Reply reply = new Reply(post);
				reply.setId(rs.getInt("id"));
				reply.setContent(rs.getString("content"));
				reply.setOwner(userDao.getByUsername(rs.getString("user_username")));
				
				replies.add(reply);
			}
			
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return replies;
	}
}
