package br.com.uff.socialmedia.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import br.com.uff.socialmedia.controller.connector.Connector;
import br.com.uff.socialmedia.model.User;

public class UserDao implements Dao<User> {
	
	@Override
	public void save(User user) {
		Connection con = Connector.getConnection();
		
		try {
			PreparedStatement st = con.prepareStatement("insert into user(username, email, name, password, icon) values(?, ?, ?, ?, ?)");
			st.setString(1, user.getUsername());
			st.setString(2, user.getEmail());
			st.setString(3, user.getName());
			st.setString(4, user.getPassword());
			st.setString(5, user.getIcon().getNome());
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
			PreparedStatement st = con.prepareStatement("delete from user where id=?");
			st.setInt(1, id);
			st.executeUpdate();	
			
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public User getByEmail(String email) {		
		Connection con = Connector.getConnection();
		User usuario = null;

		try {
			PreparedStatement st = con.prepareStatement("select * from user where email=?");
			st.setString(1, email);
			ResultSet rs = st.executeQuery();
			
			if (rs.next()) {
				usuario = new User();
				usuario.setUsername(rs.getString("username"));
				usuario.setEmail("email");
				usuario.setName(rs.getString("name"));
				usuario.setPassword(rs.getString("password"));
				usuario.setIcon(rs.getString("icon"));
				con.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return usuario;	
	}
	
	public User getByUsername(String username) {		
		Connection con = Connector.getConnection();
		User usuario = null;

		try {
			PreparedStatement st = con.prepareStatement("select * from user where username=?");
			st.setString(1, username);
			ResultSet rs = st.executeQuery();
			
			if (rs.next()) {
				usuario = new User();
				usuario.setUsername(rs.getString("username"));
				usuario.setEmail("email");
				usuario.setName(rs.getString("name"));
				usuario.setPassword(rs.getString("password"));
				usuario.setIcon(rs.getString("icon"));
				con.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return usuario;	

	}

	public List<User> getAll() {
		Connection con = Connector.getConnection();
		List<User> usuarios = new ArrayList<User>();

		try {
			PreparedStatement st = con.prepareStatement("select * from user");
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				User usuario = new User();
				usuario.setUsername(rs.getString("username"));
				usuario.setEmail("email");
				usuario.setName(rs.getString("name"));
				usuario.setPassword(rs.getString("password"));
				usuario.setIcon(rs.getString("icon"));
				usuarios.add(usuario);
			}
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return usuarios;	
	}

	public User update(String email, User usuario) {

		Connection con = Connector.getConnection();
		
		try {
			PreparedStatement st1 = con.prepareStatement("delete from user where email=?");
			st1.setString(1, email);
			st1.executeUpdate();
			
			PreparedStatement st = con.prepareStatement("insert into user(username, email, name, password, icon) values(?, ?, ?, ?, ?)");
			st.setString(1, usuario.getUsername());
			st.setString(2, usuario.getEmail());
			st.setString(3, usuario.getName());
			st.setString(4, usuario.getPassword());
			st.setString(5, usuario.getIcon().getNome());
			st.executeUpdate();

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		
		return usuario;
	}
	
	public void resetPassword(User usuario) {
		Connection con = Connector.getConnection();
		PreparedStatement st;
		try {
			st = con.prepareStatement("update user set password=? where email=?");
			st.setString(2, usuario.getEmail());
			st.setString(1, usuario.getPassword());
			st.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
