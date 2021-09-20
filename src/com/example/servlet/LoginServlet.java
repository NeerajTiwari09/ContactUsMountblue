package com.example.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.dao.LoginDao;
import com.example.dao.RequestDao;
import com.example.model.ContactRequest;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	public static final String EMAIL = "email";
	public static final String PASSWORD = "password";

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.sendRedirect("login.jsp");
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		String email = request.getParameter("email").toString();
		String password = request.getParameter("password").toString();
		try {
			LoginDao loginDao = new LoginDao();
			if(loginDao.checkLoginAuthentication(email, password)) {
				RequestDao requestDao = new RequestDao();
				HttpSession session = request.getSession();
				session.setAttribute(EMAIL, email);
				session.setAttribute(PASSWORD, password);
				List<ContactRequest> contactRequests = requestDao.getRequests();
				session.setAttribute("requests", contactRequests);
				response.sendRedirect("request.jsp");
			}
			else {
				response.sendRedirect("login.jsp");
			}
		}
		catch( IOException e) {
			e.printStackTrace();
		}
	}
}
