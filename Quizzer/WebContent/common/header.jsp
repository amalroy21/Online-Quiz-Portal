<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<link href="css/headerStyle.css" rel="stylesheet" type="text/css">
<body>
<%
    if ((session.getAttribute("un") == null) || (session.getAttribute("un") == "")) {
    	response.sendRedirect("index.jsp");
    }
%>
<div class="topbar" id="topbar" >
	<div class="mainmenu" style="display:inline-block">
		<div class="menulist" style="display:inline-block">
			<a href="index.jsp" class="menulistitem" title="TechnoCrunch" rel="home" >TechnoCrunch</a>
		</div>	
		<div class="menulist" style="display:inline-block">
			<a href="userHome.jsp" class="menulistitem" title="TechnoCrunch" rel="home" >Quizzer</a>
		</div>
		<div class="menulist" style="display:inline-block">
			<a href="viewResults.jsp" class="menulistitem" title="TechnoCrunch" rel="home" >View Results</a>
		</div>
		<div class="menulist" style="display:inline-block">
			<a href="Logout" class="menulistitem" title="TechnoCrunch" rel="home" >Logout</a>
		</div>
		<div class="menulist" style="display:inline-block">
			<a href="register.jsp" class="menulistitem" title="TechnoCrunch" rel="home" >Register</a>
		</div>
		</div>
</div>

</body>
</html>