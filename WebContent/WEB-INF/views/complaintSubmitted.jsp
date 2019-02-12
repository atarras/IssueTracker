<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/resources/css/style.css">
<title>Issue Tracker - Submission Confirmation</title>
</head>
<body bgcolor="#D1CCD6">
	
	<%@ include file="header.jsp" %>
	
	<center>
	<div style="margin-top:10%"> </div>
		<font size="6">Complaint Successfully submitted!</font>
		<div style="margin-top:3%"></div>
		<font size="4">Your complaint will be handle shortly.</font>
	<form action="home" method="get" class ="complaintSubmittedContainer">
		<button type="submit">Back to Homepage</button>
	</form>
	</center>
</body>
</html>