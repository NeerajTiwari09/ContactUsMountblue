package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.connector.Dao;
import com.example.model.ContactRequest;

public class RequestDao {
	
	public List<ContactRequest> getRequests(){
		List<ContactRequest> contactRequests = new ArrayList<>();
		
		try{
			Connection connection = Dao.getConnectionInstance();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM requests ORDER BY timestamp desc");
			while(resultSet.next()){
				ContactRequest contactRequest = new ContactRequest();
				contactRequest.setEmail(resultSet.getString(1));
				contactRequest.setName(resultSet.getString(2));
				contactRequest.setMessage(resultSet.getString(3));
				contactRequest.setTimeStamp(resultSet.getTimestamp(4));
				contactRequest.setActive(resultSet.getBoolean(5));
				contactRequest.setRequestId(resultSet.getInt(6));
				contactRequests.add(contactRequest);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return contactRequests;
	}
	
	public boolean setActiveOrArchived(ContactRequest contactRequest) {
		Connection connection = Dao.getConnectionInstance();
		try {
			boolean status = contactRequest.isActive();
			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE requests SET status = ? where \"requestId\" = ?");
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
