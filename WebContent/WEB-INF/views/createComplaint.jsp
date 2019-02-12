<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/resources/css/style.css">
<title>Issue Tracker - Submit Complaint</title>
</head>
<body bgcolor="#D1CCD6">

	<%@ include file="header.jsp"%>

	<div style="margin-top: 2%"></div>
	<center>
		<font size="8">Issue Description</font>
	</center>
	<form action="submitComplaint" method="post">
		<div class="newComplaintContainer">
			<label><b>Subject:</b></label> <input type="text"
				id="newComplaintSubject" placeholder="Subject" name="subject"
				required> <label><b>Description:</b></label>
			<textarea type="text" id="newComplaintDescription"
				placeholder="Description..." name="description" required> 
		</textarea>

		</div>

		<div class="bottomContainer"
			style="margin-left: 21%; margin-right: 21%;">
			<button type="submit" name="submitComplaintbtn"
				id="submitComplaintbtn">Submit Complaint</button>
			<form action="home" method="get">
				<button type="button" name="cancelComplaintbtn" id="cancelComplaintbtn">Cancel</button>
			</form>
		</div>
	</form>
</body>
</html>