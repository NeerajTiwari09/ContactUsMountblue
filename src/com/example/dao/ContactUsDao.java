package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.example.connector.Dao;
import com.example.model.Request;

public class ContactUsDao {
	
	public boolean setContactUs(Request request) {
		try {
			Connection con = Dao.getConnectionInstance();
			PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO requests values(?,?,?,?,?)");
			preparedStatement.setString(1, request.getEmail());
			preparedStatement.setString(2, request.getName());
			preparedStatement.setString(3, request.getMessage());
			preparedStatement.setTimestamp(4, request.getTimeStamp());
			preparedStatement.setBoolean(5, request.isActive());

			int flag = preparedStatement.executeUpdate();
			if(flag == 1) {
				return true;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
