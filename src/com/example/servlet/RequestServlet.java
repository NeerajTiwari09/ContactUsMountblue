package com.example.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.parser.*;

import com.example.dao.RequestDao;
import com.example.model.Request;



@WebServlet("/active")
public class RequestServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
//		try {
			
			RequestDao requestDao = new RequestDao();
			Request obj = null;
//			try {
//				obj = (Request) new JSONParser().parse(request.getParameter("req").toString());
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			Request req = requestDao.setActiveOrArchived(obj);
			
			System.out.println(request.getParameter("req").toString());
//		} 
//		catch (ParseException e) {
//			e.printStackTrace();
//		}
	}
	
	
}
