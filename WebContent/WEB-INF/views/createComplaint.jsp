<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="resources/css/style.css">
<title>Issue Tracker - Submit Complaint</title>
</head>
<body bgcolor="#D1CCD6">

	<!-- Start of Header area -->
	<div class="navbar">
		<a id="imagelogo" href="index.jsp"> <img
			src="/resources/img/logo2.png" alt="">
		</a> <a href="logout" style="float: right">Logout</a> <a href="about.html"
			style="float: right">About</a>
	</div>
	<!-- End of Header area -->

	<div style="margin-top: 2%"></div>
	<center>
		<font size="8">Issue Description</font>
	</center>
	<form action="submitComplaint" method="post"
		style="margin-left: 21%; margin-right: 21%;">
		<div class="newComplaintContainer">
			<label><b>Subject:</b></label> <input type="text"
				id="newComplaintSubject" placeholder="Subject" name="subject"
				required> <label><b>Description:</b></label>
			<textarea type="text" id="newComplaintDescription"
				placeholder="Description..." name="description" required> 
		</textarea>

		</div>

		<div class="bottomContainer">
			<button type="submit" name="submitComplaintbtn"
				id="submitComplaintbtn"">Submit Complaint</button>
			<button type="button" name="cancelComplaintbtn" action="home"
				id="cancelComplaintbtn">Cancel</button>
		</div>
	</form>
</body>
</html>