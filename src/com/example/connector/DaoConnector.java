package com.example.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoConnector {
	private static Connection connection;
	
	private DaoConnector(){
		
	}
	
	public static Connection getConnectionInstance() {
		try {
			if(connection == null) {
				Class.forName("org.postgresql.Driver");
				String username = "root";
				String password = "=";
				String url = "jdbc:postgresql://localhost:5432/contactus";
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
