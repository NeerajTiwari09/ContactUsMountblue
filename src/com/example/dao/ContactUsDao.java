package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.example.connector.DaoConnector;
import com.example.model.ContactRequest;

public class ContactUsDao {
	
	public boolean insertContactUsData(ContactRequest contactRequest) {
		try {
			Connection con = DaoConnector.getConnectionInstance();
			String query = "INSERT INTO requests(email, fullname, message, timestamp, status) values(?,?,?,?,?)";
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, contactRequest.getEmail());
			preparedStatement.setString(2, contactRequest.getName());
			preparedStatement.setString(3, contactRequest.getMessage());
			preparedStatement.setTimestamp(4, contactRequest.getTimeStamp());
			preparedStatement.setBoolean(5, contactRequest.isActive());
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
