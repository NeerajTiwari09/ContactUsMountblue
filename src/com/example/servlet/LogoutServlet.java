package com.example.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	public static final String EMAIL = "email";
	public static final String PASSWORD = "password";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			session.removeAttribute(EMAIL);
			session.removeAttribute(PASSWORD);
			session.invalidate();
			response.sendRedirect("login.jsp");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
