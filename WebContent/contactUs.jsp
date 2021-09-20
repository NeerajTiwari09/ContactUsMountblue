<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contact Us</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	
	<div class="box">
	<h1>Contact Us</h1>
	<form action= "contactus" method="post">
	 <div class="txt_field">
        <!--   <input type="text" name="email" required> -->
          <input  type= "text" name="fullname" required = "required">
          <span></span>
          <label>Name</label>
        </div>
        <div class="txt_field">
        <!--   <input type="text" name="email" required> -->
          <input  type= "email" name="email" required = "required">
          <span></span>
          <label>Email</label>
        </div>
         <div class="txt_field">
        <!--   <input type="text" name="email" required> -->
          <input class="textarea-field" name="message" required = "required" rows="4" cols="50">
          <span></span>
          <label>Type your message here...</label>
        </div>
        
		<!-- <label>Name: </label>
		<input class="input-field" type= "text" name="fullname" required = "required">
		<label>Email: </label>
		<input class="input-field" type= "email" name="email" required><br>
		<label>Message: </label><br>
		<textarea class="textarea-field" name="message" rows="4" cols="50" required></textarea><br> -->
		<input class="btn" type= "submit" value="Submit"> 	
	</form>
	</div>
	
</body>
</html>