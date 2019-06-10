package br.com.uff.socialmedia.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.uff.socialmedia.conector.Conector;
import br.com.uff.socialmedia.model.User;

public class UserDao implements Dao<User> {
	private static List<User> usuarios = new ArrayList<User>();
	Connection con = Conector.getConnection();

	@Override
	public void save(User user) {
		Connection con = Conector.getConnection();
		PreparedStatement st;
		try {
			st = con.prepareStatement("insert into user values(?,?,?,?,?)");
			st.setString(1, user.getUsername());
			st.setString(2, user.getEmail());
			st.setString(3, user.getName());
			st.setString(4, user.getPassword());
			st.setString(5, user.getIcon().getNome());
			st.executeUpdate();
			usuarios.add(user);
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int index) {
		usuarios.remove(index);

	}

	@Override
	public void lista() {
		usuarios.forEach(usuario -> {
			System.out.println(usuario);
		});
	}

	public User get(String email) {
		Connection con = Conector.getConnection();
		PreparedStatement st;
		try {
			st = con.prepareStatement("select username, name, password, icon from user where email='" + email + "'");
			ResultSet rs = st.executeQuery();
			User usuario = new User();
			if (rs.next()) {
				usuario.setUsername(rs.getString(1));
				usuario.setName(rs.getString(2));
				usuario.setPassword(rs.getString(3));
				usuario.setIcon(rs.getString(4));
				con.close();
				return usuario;
			} else {
				con.close();
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public List<User> getAll() {
		return usuarios;
	}

	public User update(String email, User usuario) {
		for (User user : usuarios) {
			if (user.getEmail().equals(email)) {
				delete(usuarios.indexOf(usuario));
				usuarios.add(usuario);
				return usuario;
			}
			;
		}
		return null;
	}
}
