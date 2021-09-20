<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contact Us</title>
</head>
<body>
	
	<form action= "contactus" method="post">
		Name: <br><input type= "text" name="fullname"><br>
		Email: <br><input type= "email" name="email"><br>
		Message: 
		<br><textarea name="message" rows="4" cols="50"></textarea><br>
		<input type= "submit" value="Submit"> 
		
	</form>
	
</body>
</html>