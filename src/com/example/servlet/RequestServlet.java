package com.example.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.RequestDao;
import com.example.model.Request;

@WebServlet("/active")
public class RequestServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			
			RequestDao requestDao = new RequestDao();
//			Request req = requestDao.setActiveOrArchived(request.getParameter("req"));
		} 
		catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	
}
