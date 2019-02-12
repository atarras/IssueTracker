<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
		<font size="8">Complaint Description</font>
		<br>
	</center>
	<div class="newComplaintContainer">
		<label><b>Subject: </b></label> <label id="newComplaintSubject">${complaintObject.getSubject()}</label>

		<label><b>Description:</b></label>
		<p id="newComplaintDescription">${complaintObject.getDescription()}</p>

		<c:if test="${user.getType() eq 'CUSTOMER'}">
			<label><b>Status:</b></label>
			<p id="newComplaintDescription">${complaintObject.getStatus()}</p>
		</c:if>

		<c:if test="${user.getType() eq 'ADMIN'}">
			<form action="changeComplaint" method="get">
				<label><b>Department:</b></label> 
				<select name="departmentSelect">
					<c:forEach var="department" items="${departmentArr}">
						<option value="${department.toString()}" 
							<c:if test="${department.toString() eq complaintObject.getDepartment()}">selected</c:if>
						>${department.toString()}</option>
					</c:forEach>
				</select>
				<br>
				<label><b>Completed:</b></label>
				<input type="checkbox" id="completedCheckbox" name="completedCheckbox"
					<c:if test="${complaintObject.getStatus() eq 'COMPLETED'}">checked</c:if>
				>
				<input type="hidden" name=complaintID value="${complaintObject.getComplaintID()}">
				<button type="submit" id="submitComplaintbtn">Confirm</button>
			</form>
		</c:if>
	</div>

	<div class="bottomContainer" style="margin-left: 21%; margin-right: 21%;">
		<form action="home" method="post">
			<button type="submit" name="cancelComplaintbtn"
				id="cancelComplaintbtn">Cancel</button>
		</form>
	</div>
</body>
</html>