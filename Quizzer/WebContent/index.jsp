<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TECHNO-CRUNCH</title>
</head>
<link href="css/loginStyle.css" rel="stylesheet" type="text/css">
<body>
<% 
	String userValidity=request.getParameter("valid");
	if("false".equalsIgnoreCase(userValidity)){
		%>
		<script>alert("Invalid Credentials!");</script>
		<%
	}
%>
	<div class="wrapper">
		
		<form action=Login method=get class="login">
		<p class="title">Log in</p>
	    <input name="username" type="text" placeholder="Username" autofocus/>
	    <i class="fa fa-user"></i>
	    <input name="password" type="password" placeholder="Password" />
	    <i class="fa fa-key"></i>
	    <a href="resetPassword.jsp">Forgot your password?</a>
    	<select name=role>
			<option value=candidate selected>Candidate</option>
			<option value=company>Company</option>
		</select><br><br>
		<a href="register.jsp">Not registered? Click here to Register Now.</a>
	    <button type="submit">
	      <i class="spinner"></i>
	      <span class="state">Log in</span>
	    </button>
	    	
		</form>
	</div>

</body>
</html>