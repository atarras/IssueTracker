<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Issue Tracker - Admin Home</title>
<link rel="stylesheet" href="resources/css/style.css">
</head>
<body bgcolor="#D1CCD6">
	<!-- Start of Header area -->
	<div class="navbar">
		<a id="imagelogo" href="index.html"> <img src="logo2.png" alt="">
		</a> <a href="login" style="float: right">Logout</a> <a href="about.html"
			style="float: right">About</a>
	</div>
	<!-- End of Header area -->

	<div style="margin-top: 5%"></div>

	<div class="myComplaintsContainer">
		<div class="myComplaintstitle">
			<center>
				<font size="6">All Complaints</font>
			</center>
		</div>
	</div>

	<table>
		<tr>
			<th>Subject</th>
			<th>Issue ID</th>
			<th>Status</th>
			<th>User ID</th>
		</tr>
		<c:forEach items="${allComplaints}" var="complaint">
			<tr>
				<td>${complaint.getSubject()}</td>
				<td>${complaint.getComplaintID()}</td>
				<td>${complaint.getStatus()}</td>
				<td>${complaint.getUserID()}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>