<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<link rel="stylesheet" href="resources/css/style.css">
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