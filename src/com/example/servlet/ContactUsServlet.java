package com.example.servlet;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.ContactUsDao;
import com.example.model.ContactRequest;

@WebServlet("/contactus")
public class ContactUsServlet extends HttpServlet {
	
	public static final String FULLNAME = "fullname";
	public static final String EMAIL = "email";
	public static final String MESSAGE= "message";
	
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
			ContactRequest contactRequest = new ContactRequest();
			contactRequest.setName(httpRequest.getParameter(FULLNAME));
			contactRequest.setEmail(httpRequest.getParameter(EMAIL));
			contactRequest.setMessage(httpRequest.getParameter(MESSAGE));
			contactRequest.setActive(true);
			contactRequest.setTimeStamp(new Timestamp(System.currentTimeMillis()));
			
			ContactUsDao contactUsDao = new ContactUsDao();
			if(contactUsDao.insertContactUsData(contactRequest)) {
				httpResponse.getWriter().print("Submitted");
			}	
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
