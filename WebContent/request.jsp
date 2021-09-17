<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*, com.example.model.*, java.util.*" %>
    <%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Requests</title>
<style>
* {
  box-sizing: border-box;
}

.row {
  margin-left:-5px;
  margin-right:-5px;
}
  
.column {
  float: left;
  width: 50%;
  padding: 5px;
}

/* Clearfix (clear floats) */
.row::after {
  content: "";
  clear: both;
  display: table;
}

table {
  border-collapse: collapse;
  border-spacing: 0;
  width: 100%;
  border: 1px solid #ddd;
}

th, td {
  text-align: left;
  padding: 16px;
}

tr:nth-child(even) {
  background-color: #f2f2f2;
}
</style>
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
	%>
	<div class="row">
		<div class="column">
			<table>
				<th>Active</th>
				<c:forEach items="${requests}" var = "req">
				<tr><td>${req.name}<br>${req.email}<br>${req.message}<form action="active" method="post">
				<input type="hidden" name="myObject" value="${req}"/><input type="submit" value="Mark as archive"></form><br>
				</c:forEach>
			</table>
		</div>
	
		<div class="column">
			<table>
			<th>Archived</th>
			<c:forEach items="${requests}" var = "req">
				<tr><td>${req.name}<br>${req.email}<br>${req.message}<form action="active" method="post">
				<input type="hidden" name="myObject" value="${req}"/><input type="submit" value="Mark as active"></form><br>
			</c:forEach>
		</table>
	</div>
	</div>

</body>
</html>