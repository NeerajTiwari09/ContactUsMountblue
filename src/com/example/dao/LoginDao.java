package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.connector.Dao;

public class LoginDao {
	
	public boolean check(String email, String password) {
		try {
			Connection connection = Dao.getConnectionInstance();
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM login WHERE email = ? and password = ?");
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
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
