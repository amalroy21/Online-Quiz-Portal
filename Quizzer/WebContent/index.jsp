<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TECHNO-CRUNCH</title>
</head>
<body>
	<div id="header">
	    <jsp:include page="common/header.jsp"/>
	</div>
	<div style="margin:10%;margin-top:100px;">
		<h3 >Log into your account</h3>
		<form action=Login method=get>
		<label>User Name</label>
		<input type=text name=uname><br><br>
		<label>Password</label>
		<input type=password name=psw><br><br>
		<select name=desig>
				<option value=user selected>Student</option>
				<option value=admin>Recruiter</option>
			</select><br><br>
		<input type=submit value="Login" />
		</form>
	</div>
</body>
</html>