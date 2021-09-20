package com.example.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.dao.RequestDao;
import com.example.model.ContactRequest;




@WebServlet("/active")
public class RequestServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			RequestDao requestDao = new RequestDao();
			ContactRequest contactRequest = new ContactRequest();
			String status = request.getParameter("reqStatus");
			int requestId = Integer.valueOf(request.getParameter("reqId"));
	
			contactRequest.setActive(Boolean.valueOf(status));
			contactRequest.setRequestId(requestId);
			
			if(requestDao.setActiveOrArchived(contactRequest)) {
				List<ContactRequest> contactRequests = requestDao.getRequests();
				HttpSession session = request.getSession();
				session.setAttribute("requests", contactRequests);
				response.sendRedirect("request.jsp");
			}
			else {
				response.getWriter().print("Something error...");
			}	
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
