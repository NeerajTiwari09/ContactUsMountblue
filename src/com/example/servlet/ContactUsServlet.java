package com.example.servlet;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.ContactUsDao;
import com.example.model.Request;

@WebServlet("/contactus")
public class ContactUsServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.sendRedirect("contactUs.jsp");
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void doPost(HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
		
		try {
			Request request = new Request();
			request.setName(httpRequest.getParameter("fullname"));
			request.setEmail(httpRequest.getParameter("email"));
			request.setMessage(httpRequest.getParameter("message"));
			request.setActive(true);
			request.setTimeStamp(new Timestamp(System.currentTimeMillis()));
			
			ContactUsDao contactUsDao = new ContactUsDao();
			if(contactUsDao.setContactUs(request)) {
				httpResponse.getWriter().print("Submitted");
			}
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
