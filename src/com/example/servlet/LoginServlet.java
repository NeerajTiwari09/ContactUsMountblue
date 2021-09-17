package com.example.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.dao.LoginDao;
import com.example.dao.RequestDao;
import com.example.model.Request;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

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
			
			if(loginDao.check(email, password)) {
				RequestDao requestDao = new RequestDao();
				HttpSession session = request.getSession();
				session.setAttribute("email", email);
				session.setAttribute("password", password);
				List<Request> requests = requestDao.getRequests();
				request.setAttribute("requests", requests);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("request.jsp");
				requestDispatcher.forward(request, response);
//				response.sendRedirect("request.jsp");
			}
			else {
				response.sendRedirect("login.jsp");
			}
		}
		catch(ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}
