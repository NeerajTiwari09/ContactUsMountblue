package com.example.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {
	private static Connection connection;
	
	private Dao(){
		
	}
	
	public static Connection getConnectionInstance() {
		try {
			if(connection == null) {
//				Class.forName("org.postgresql.Driver");
//				Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ipl", "root", "=");
				Class.forName("com.mysql.jdbc.Driver");
				String username = "root";
				String password = "root8080";
				String url = "jdbc:mysql://localhost:3306/contactus";
				connection = DriverManager.getConnection(url, username, password);
				return connection;
			}
		}
		catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
