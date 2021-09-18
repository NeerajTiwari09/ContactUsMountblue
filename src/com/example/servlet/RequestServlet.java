package com.example.servlet;

import java.io.IOException;
import java.io.Reader;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import com.example.dao.RequestDao;




@WebServlet("/active")
public class RequestServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			
			RequestDao requestDao = new RequestDao();
			String string = request.getParameter("req");
			
	        
			JSONObject object =  (JSONObject) new JSONParser().parse(string);
			

//			Request req = new Request();
//			req.setEmail((String) object.get("name"));
			
//			Request req = requestDao.setActiveOrArchived(obj);
			
			response.getWriter().println(string + "  " /*+ (String) object.get("name")*/);
			
		} 
		catch (IOException | ParseException e) {
			e.printStackTrace();
		}
	}
	
	
}
