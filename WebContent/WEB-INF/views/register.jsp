<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Issue Tracker - Registration Page</title>
<link rel="stylesheet" href="resources/css/style.css">
</head>
<body bgcolor="#D1CCD6">
	<div style="margin-top:3%"></div>
	<center>
		<font size="8"> Register </font>
		
		<h2 class="error">${errorMsg}</h2>
		 
		<form action="registration" method="post">
		    <div class="regcontainer">
				<label for="firstname"><b>First name:</b></label>
				<input type="text" placeholder="First Name" name="fname" required>

				<label for="lastname"><b>Last name:</b></label>
				<input type="text" placeholder="Last Name" name="lname" required>
				
				<label for="username"><b>Username:</b></label>
				<input type="text" placeholder="Username" name="username" required>
				
				<label for="email"><b>Email:</b></label>
				<input type="email" placeholder="mail@example.com" name="email" required>
				
				<label for="confemail"><b>Confirm Email:</b></label>
				<input type="email" placeholder="mail@example.com" name="confemail" required>
				
				<label for="psw"><b>Password:</b></label>
				<input type="password" placeholder="Enter Password" name="password" required>
				
				<label for="psw"><b>Confirm Password:</b></label>
				<input type="password" placeholder="Confirm Password" name="confpassword" required>
					
				<button type="submit">Register</button>
		    </div>
		</form>
		<form action="cancelRegistration" method="get" class="bottomContainer">
			<button type="submit" id="regcancelbtn">Cancel</button>
		</form>
	</center>
</body>
</html>