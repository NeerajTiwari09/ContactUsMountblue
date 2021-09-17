package com.example.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.connector.Dao;
import com.example.model.Request;

public class RequestDao {
	
	public List<Request> getRequests(){
		List<Request> requests = new ArrayList<>();
		
		try{
			Connection connection = Dao.getConnectionInstance();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM requests ORDER BY dateEntered desc");
			while(resultSet.next()){
				Request request = new Request();
				request.setEmail(resultSet.getString(1));
				request.setName(resultSet.getString(2));
				request.setMessage(resultSet.getString(3));
				request.setTimeStamp(resultSet.getTimestamp(4));
				request.setActive(resultSet.getBoolean(5));
				requests.add(request);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return requests;
	}
}
