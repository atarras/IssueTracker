<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>	

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="resources/css/style.css">
<title>Issue Tracker - Complaint Details</title>
</head>
<body bgcolor="#D1CCD6">

	<%@ include file="header.jsp"%>

	<div style="margin-top: 2%"></div>
	<center>
		<font size="8">Issue Description</font>
	</center>
	<div class="newComplaintContainer">
		<label><b>Subject: </b></label> <label id="newComplaintSubject">${complaintObject.getSubject()}</label>

		<label><b>Description:</b></label>
		<p id="newComplaintDescription">${complaintObject.getDescription()}</p>
	</div>

	<div class="bottomContainer"
		style="margin-left: 21%; margin-right: 21%;">
		<form action="home" method="get">
			<button type="button" name="cancelComplaintbtn"
				id="cancelComplaintbtn">Cancel</button>
		</form>
	</div>
</body>
</html>