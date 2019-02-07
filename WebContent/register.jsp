<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#D1CCD6">
	<div style="margin-top:3%"></div>
	<center>
		<font size="8"> Register </font> 
		<form action="index.html">
		    <div class="regcontainer">
				<label for="firstname"><b>First name:</b></label>
				<input type="text" placeholder="First Name" name="fname" required>

				<label for="lastname"><b>Last name:</b></label>
				<input type="text" placeholder="Last Name" name="lname" required>
				
				<label for="email"><b>Email:</b></label>
				<input type="text" placeholder="mail@example.com" name="email" required>
				
				<label for="confemail"><b>Confirm Email:</b></label>
				<input type="text" placeholder="mail@example.com" name="confemail" required>
				
				<label for="psw"><b>Password:</b></label>
				<input type="password" placeholder="Enter Password" name="password" required>
				
				<label for="psw"><b>Confirm Password:</b></label>
				<input type="password" placeholder="Confirm Password" name="confpassword" required>
					
				<button type="submit">Register</button>
		    </div>
			
		  <div class="bottomContainer">
			<button type="button" id="regcancelbtn">Cancel</button>
		  </div>
		</form>
	</center>
</body>
</html>