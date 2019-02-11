<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.fdmgroup.model.Complaint"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Issue Tracker - Customer Home</title>
<link rel="stylesheet" href="resources/css/style.css">
</head>
<body bgcolor="#D1CCD6">

	<%@ include file="header.jsp" %>

	<div style="margin-top: 5%"></div>

	<div class="myComplaintsContainer">
		<div class="myComplaintstitle">
			<center>
				<font size="6">My Complaints</font>
			</center>
		</div>
	</div>

	<table>
		<tr>
			<th>Subject</th>
			<th>Issue ID</th>
			<th>Status</th>
		</tr>
		<c:forEach items="${userComplaints}" var="complaint">
			<tr>
				<td>${complaint.getSubject()}</td>
				<td>${complaint.getComplaintID()}</td>
				<td>${complaint.getStatus()}</td>
				<td>
					<form action = "seeComplaint" method = "post">
						<input type="hidden" name="complaintID" value="${complaint.getComplaintID()}">
						<button type="submit">See details...</button>
					</form> 
				</td>
			</tr>
		</c:forEach>
	</table>

	
	<form action="complaint" method="get">
		<button type="submit" id="newComplaintbtn">Create New
			Complaint</button>
	</form>

</body>
</html>