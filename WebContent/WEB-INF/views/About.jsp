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
<meta charset="ISO-8859-1">
<title>Issue Tracker - About</title>
<link rel="stylesheet" href="resources/css/style.css">
</head>
<body bgcolor="#D1CCD6">

	<%@ include file="header.jsp" %>

	<div style="margin-top: 3%"></div>
	<center>
		<div class="aboutTextContainer">
			<font size="5"> IssueTracker is a web-based application that
				allows our customers to file complaints about FDM Group. Our
				Administrators will transfer any complaint to the appropriate
				department and make sure it is processed within seven Business days.
				We are always eager to hear from our customers and take every
				opinion seriously. At FDM Group, the clients' satisfaction is our
				priority! </font>
		</div>

		<div style="margin-top: 3%"></div>
		<font size="8"> Meet our wonderful Team!</font>
			<div class="bigGrid">
				<div id="imageContainer">
					<a href="#"> <img src="resources/img/gharnata.jpg"
						style="width: 100%">
					</a>
				</div>

				<div id="imageContainer">
					<a href="#"> <img src="resources/img/diarra.jpg" style="width: 100%">
					</a>
				</div>

				<div id="imageContainer">
					<a href="#"> <img src="resources/img/karam.jpg" style="width: 100%">
					</a>
				</div>

				<div id="imageContainer">
					<a href="#"> <img src="resources/img/gabriel.jpg"
						style="width: 100%">
					</a>
				</div>

				<div id="imageContainer">
					<a href="#"> <img src="resources/img/kartik.jpg" style="width: 100%">
					</a>
				</div>

				<div id="imageContainer">
					<a href="#"> <img src="resources/img/andrew.jpg" style="width: 100%">
					</a>
				</div>

				<div id="imageContainer">
					<a href="#"> <img src="resources/img/aj.jpg" style="width: 100%">
					</a>
				</div>

				<div id="imageContainer">
					<a href="#"> <img src="resources/img/mandeep.jpg" style="width: 100%">
					</a>
				</div>
			</div>
	</center>

	<div style="margin-top: 4%"></div>


</body>
</html>