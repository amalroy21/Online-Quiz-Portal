<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Question Saved</title>
</head>
<body>
	
	<div id="leftSideBar">
	    <jsp:include page="leftSideBarComp.jsp"/>
	</div>
	<div class="content" style="float:left">
		<p>Question was added successfully to the question bank.</p>
		<br>
		<br>
		<ul>
		<li><a href="companyHome.jsp">Home Page</a></li>
		<li><a href="insertQuestion.jsp">Submit more questions</a></li>
		</ul>
	</div>
	
</body>
</html>