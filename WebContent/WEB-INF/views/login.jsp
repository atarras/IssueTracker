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
<title>Issue Tracker - Login</title>
<link rel="stylesheet" href="resources/css/style.css">
</head>
<body bgcolor="#D1CCD6">

	<%@ include file="header.jsp" %>
	
	<center>
		<form action="processLogin" method="post" style="max-width:60%">
		<div class="logcontainer">
			<div class="logimgcontainer">
				<img src="resources/img/log.jpg" alt="Avatar" class="logavatar">
			</div>
				<h2 class="error">${errorMsg}</h2>
		    
				<label for="uname"><b>Username</b></label>
				<input type="text" placeholder="Enter Username" name="username" required>

				<label for="psw"><b>Password</b></label>
				<input type="password" placeholder="Enter Password" name="password" required>
					
				<button type="submit" value="login">Login</button>
		</div>

		  <div class="bottomContainer">
			<button type="submit" id="logcancelbtn">Cancel</button>
			<span style="float:right">Not a member? <a href="register">Register</a></span>
		  </div>
		</form>
	</center>
</body>
</html>