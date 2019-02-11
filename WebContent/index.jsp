<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Issue Tracker - Login</title>
<link rel="stylesheet" href="resources/css/style.css">
</head>
<body bgcolor="#D1CCD6">

	<%@ include file="WEB-INF/views/header.jsp" %>

	<center>
		<div style="margin-top: 3%"></div>
		<font size="8"> Welcome to IssueTracker! </font>
		<div style="margin-top: 3%"></div>
	</center>

	<center>
		<div class="slideshow-container">

			<div class="mySlides fade">
				<a href="#"> <img src="resources/img/s1.jpg">
				</a>
			</div>

			<div class="mySlides fade">
				<a href="#"> <img src="resources/img/s2.jpg">
				</a>
			</div>

			<div class="mySlides fade">
				<a href="#"> <img src="resources/img/s3.jpg">
				</a>
			</div>

		</div>
	</center>


	<br>

	<div style="text-align: center">
		<span class="dot"></span> <span class="dot"></span> <span class="dot"></span>
	</div>

	<script>
		var slideIndex = 0;
		showSlides();

		function showSlides() {
			var i;
			var slides = document.getElementsByClassName("mySlides");
			var dots = document.getElementsByClassName("dot");
			for (i = 0; i < slides.length; i++) {
				slides[i].style.display = "none";
			}
			slideIndex++;
			if (slideIndex > slides.length) {
				slideIndex = 1
			}
			for (i = 0; i < dots.length; i++) {
				dots[i].className = dots[i].className.replace(" active", "");
			}
			slides[slideIndex - 1].style.display = "block";
			dots[slideIndex - 1].className += " active";
			setTimeout(showSlides, 3000); // Change image every 2 seconds
		}
	</script>
</body>
</html>