<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.fdmgroup.model.Complaint"%>
<%@ page import="java.util.List"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<c:set var="req" value="${pageContext.request}" />
<c:set var="url">${req.requestURL}</c:set>
<c:set var="uri" value="${req.requestURI}" />
<!DOCTYPE html>
<html>
<head>
<base href="${fn:substring(url, 0, fn:length(url) - fn:length(uri))}${req.contextPath}/" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Issue Tracker - Customer Home</title>
<link rel="stylesheet" href="resources/css/style.css">
</head>
<body bgcolor="#D1CCD6">

	<%@ include file="header.jsp"%>

	<div style="margin-top: 5%"></div>

	<div class="myComplaintsContainer">
		<div class="myComplaintstitle">
			<center>
				<font size="6">${listTitle}</font>
				<h2 class="error">${errorMsg}</h2>
			</center>
		</div>
	</div>

	<table>
		<tr>
			<th>Subject</th>
			<th>Issue ID</th>
			<th>Status</th>
			<c:if test="${user.getType() eq 'ADMIN'}">
				<th>User ID</th>
			</c:if>
		</tr>
		<c:forEach items="${complaintList}" var="complaint">
			<tr>
				<td>${complaint.getSubject()}</td>
				<td><a
					href="seeComplaint?complaint=${complaint.getComplaintID()}">
						${complaint.getComplaintID()}</a></td>
				<td>${complaint.getStatus()}</td>
				<c:if test="${user.getType() eq 'ADMIN'}">
					<td>${complaint.getUserID()}</td>
				</c:if>
			</tr>
		</c:forEach>
	</table>

	<c:if test="${user.getType() eq 'CUSTOMER'}">
		<form action="complaint" method="get">
			<button type="submit" id="newComplaintbtn">Create New
				Complaint</button>
		</form>
	</c:if>

</body>
</html>