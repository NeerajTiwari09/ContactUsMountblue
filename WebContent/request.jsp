<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*, com.example.model.*, java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Requests</title>
</head>
<body>

	<form action="logout">
		<input type="submit" value="Logout">
	</form>

	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
	
		if(session.getAttribute("email") == null || session.getAttribute("password") == null){
			response.sendRedirect("login.jsp");
		}
		else{
			List<Request> requests = (List<Request>)request.getAttribute("requests");
		}
	%>
	
	${requests}
	

</body>
</html>