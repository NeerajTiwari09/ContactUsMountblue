package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.connector.DaoConnector;
import com.example.model.ContactRequest;

public class RequestDao {
	
	public static final int EMAIL = 1;
	public static final int FULLNAME = 2;
	public static final int MESSAGE = 3;
	public static final int TIME_STAMP = 4;
	public static final int STATUS = 5;
	public static final int REQUEST_ID = 6;
	
	public List<ContactRequest> getRequests(){
		List<ContactRequest> contactRequests = new ArrayList<>();
		try{
			Connection connection = DaoConnector.getConnectionInstance();
			Statement statement = connection.createStatement();
			String query = "SELECT * FROM requests ORDER BY timestamp desc"; 
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()){
				ContactRequest contactRequest = new ContactRequest();
				contactRequest.setEmail(resultSet.getString(EMAIL));
				contactRequest.setName(resultSet.getString(FULLNAME));
				contactRequest.setMessage(resultSet.getString(MESSAGE));
				contactRequest.setTimeStamp(resultSet.getTimestamp(TIME_STAMP));
				contactRequest.setActive(resultSet.getBoolean(STATUS));
				contactRequest.setRequestId(resultSet.getInt(REQUEST_ID));
				contactRequests.add(contactRequest);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return contactRequests;
	}
	
	public boolean changeStatus(ContactRequest contactRequest) {
		try {
			Connection connection = DaoConnector.getConnectionInstance();
			boolean status = contactRequest.isActive();
			String query = "UPDATE requests SET status = ? where \"requestId\" = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setBoolean(1, !(status));
			preparedStatement.setInt(2, contactRequest.getRequestId());
			int flag = preparedStatement.executeUpdate();
			if(flag == 1){
				return true;
			}
		} 
		catch (SQLException e) {	
			e.printStackTrace();
		}
		return false;
	}
}
