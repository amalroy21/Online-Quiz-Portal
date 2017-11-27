<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Technocrunch</title>
</head>
<link href="css/commonStyle.css" rel="stylesheet" type="text/css">
<body>

<div class="leftSideBarParent">
    <div class="leftSideBar">
        <div class="menuDivForLeftbar"><div class="bar1"></div><div class="bar2"></div><div class="bar3"></div></div><span class="leftbarDataSpan" data-pid="0" data-lid="1" data-type="" data-termid="0"></span><div class="quickLink_S">
<table>
<tbody>
<%
	HttpSession sh=request.getSession(false);
	String name="";	
	if(sh!=null){
		Object ob=sh.getAttribute("name");
		
		if(ob!=null){
			name=(String)ob ;
		}
	}else{
		response.sendRedirect("index.jsp");
	}
%>

<tr>
<td><a href="#">Welcome <%=name %></a></td>
</tr>


<tr>
<td class="quickLink-header_S"><b>Quick Links:</b></td>
</tr>

<tr>
<td><a href="userHome.jsp">Home</a></td>
</tr>

<tr>
<td><a href="userHome.jsp">Search Company</a></td>
</tr>


<tr>
<td><a href="viewResults.jsp">View My Results</a></td>
</tr>


<tr>
<td><a href="logout.jsp">Logout</a></td>
</tr>

<tr>
<td class="quickLink-header_S"><b>Contact us:</b></td>
</tr>

<tr>
<td><a href="#">Admin@Technocrunch.com</a></td>
</tr>

</tbody>
</table>
</div>    </div>
</div>

</body>
</html>