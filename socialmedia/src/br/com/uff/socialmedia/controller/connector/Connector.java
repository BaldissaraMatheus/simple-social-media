package br.com.uff.socialmedia.controller.connector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Connector {
	public static Connection getConnection() {		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialmedia", "root", "");
			return con;	}
		catch (ClassNotFoundException | SQLException  e) {
			e.printStackTrace();} 		
		return null;}}
