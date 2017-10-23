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
    int id=0;
	Object ob=session.getAttribute("id"); 
	if (ob== null) {
    	response.sendRedirect("index.jsp");
    	System.out.print("here="+response);
	}else{
    	
    	id=Integer.parseInt((String)ob);
    	
    }
%>
<div class="topbar" id="topbar" >
	<div class="mainmenu" style="display:inline-block">
		<div class="menulist" style="display:inline-block">
			<a href="companyHome.jsp" class="menulistitem" title="TechnoCrunch" rel="home" >TechnoCrunch</a>
		</div>	
		<div class="menulist" style="display:inline-block">
			<a href="insertQuestion.jsp" class="menulistitem" title="TechnoCrunch" rel="home" >Add Question</a>
		</div> 
		<div class="menulist" style="display:inline-block">
			<a href="viewStudentResults.jsp" class="menulistitem" title="TechnoCrunch" rel="home" >View Student Results</a>
		</div>
		<div class="menulist" style="display:inline-block">
			<p>CompanyID:<%=id %></p>
		</div>
		<div class="menulist" style="display:inline-block">
			<a href="Logout" class="menulistitem" title="TechnoCrunch" rel="home" >Logout</a>
		</div>
		<div class="menulist" style="display:inline-block">
			<a href="register.jsp" class="menulistitem" title="TechnoCrunch" rel="home" >Register Now</a>
		</div>
		</div>
</div>

</body>
</html>