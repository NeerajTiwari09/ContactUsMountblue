package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.connector.DaoConnector;

public class LoginDao {
	public static final int EMAIL = 1;
	public static final int PASSWORD = 2;
	
	public boolean checkLoginAuthentication(String email, String password) {
		try {
			Connection connection = DaoConnector.getConnectionInstance();
			String query = "SELECT * FROM login WHERE email = ? and password = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(EMAIL, email);
			preparedStatement.setString(PASSWORD, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				return true;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
