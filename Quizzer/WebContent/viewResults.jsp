<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Domain.QuizResults" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="SQL.DBA" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Results</title>
</head>
<body>
<div id="leftSideBar">
    <jsp:include page="leftSideBar.jsp"/>
</div>
<div class="content">
<table border="1" style="width:30%" cellpadding="5">
<thead>
    <tr>
        <th colspan="1">Company ID</th>
    	<th colspan="1">Question Level</th>
    	<th colspan="1">Score</th>
    	<th colspan="1">Max_Marks</th>
    </tr>
</thead>
<tbody>
    
<% 
session=request.getSession();
String companyname="";
if(session!=null){
	Object ob=session.getAttribute("id");
	if(ob!=null){
		int candidateid=(int)ob;  
		if(candidateid>0){
			ArrayList<QuizResults> qz_results=new ArrayList<QuizResults>();
			DBA db=new DBA();
			qz_results=db.getResults(candidateid,"candidate");
			if(qz_results!=null && qz_results.size()>0){
				for(QuizResults rs:qz_results){
					companyname=db.getCompanyName(rs.getCompanyid());
					%>
					<tr>
				        <td><%=companyname   %></td>
				        <td><%=rs.getQlevel()%></td>
				        <td><%=rs.getScore() %></td>
				        <td><%=rs.getTotal() %></td>
				    </tr>
					<%
				}
			}
		}
	}
}
%>
</tbody>
</table>
</div>
</body>
</html>