<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TECHNO-CRUNCH</title>
</head>
<body>
<% 	String result=request.getParameter("score"); 
	int score=0;
	if(result!=null && result.length()>0 ){
		try{
			score=Integer.parseInt(result);
		}catch(NumberFormatException e){
			score=0;
		}
	}
%>
<div id="header">
    <jsp:include page="common/header.jsp"/>
</div>
<div style="margin:10%;margin-top:100px;">
	<h1>Result Page</h1>
	
	<span style="display:block;margin:1%;">Passing Score: 3</span>
	<span style="display:block;margin:1%;">Your Score   : <%=score %></span>
	<input style="margin:1%;" type="button" value="Back" onclick="window.location='userHome.jsp'"/>
</div>
	
</body>
</html>