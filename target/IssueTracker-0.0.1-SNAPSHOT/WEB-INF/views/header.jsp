<!-- Start of Header area -->
<%@page import="com.fdmgroup.model.User"%>
<div class="navbar">
	<a id="imagelogo" href="index.jsp"> 
		<img src="/resources/img/logo2.png" alt="">
	</a>
	
	<%
		User user = (User) session.getAttribute("user");
		if(user == null){
			out.write("<a href=\"login\" style=\"float: right\">Login</a>");
		} else {
			out.write("<a href=\"logout\" style=\"float: right\">Logout</a>");
		}
	%>
	
	<a href="about"	style="float: right">About</a>
</div>
<!-- End of Header area -->