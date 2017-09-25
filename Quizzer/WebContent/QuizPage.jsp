
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="Domain.Question" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.json.JSONArray" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/src_QuizPage.js?v=2"></script>
<title>TECHNO-CRUNCH</title>
</head>
<body>
<div id="header">
    <jsp:include page="common/header.jsp"/>
</div>
<div style="margin:10%;margin-top:100px;">
	<div id="PopQuiz" align="center" style="display:none;">
		<table border="1" width="500px" bgcolor="blanchedalmond" cellspacing="0" cellpadding="0">
		  <tr><td width="100%">
			<form name="quizform" id="quizform" action="">
			<h2 align="center"><font color="red">JAVA LEVEL 1</font></h2>
			
			<span style="margin-left:1%" id="no_qn">Choose correct option.</span>
			
			<span id=time style="float:right;margin-right:1%"></span>
			<input type="hidden" name="correctAns" id="correctAns" value="" />
			<input type="hidden" name="questionNo" id="questionNo" value="" />
			<table border="0" width="500px" cellspacing="2" cellpadding="4">
			<tr>
			<td width="10%"> Question:</td>
			
			<td id="Qns"></td></tr>
			<tr><td>
			1: <input type="radio" name="a" value= "A" /></td>
			    <td id="OptA"></td></tr> 
			<tr>
			<td>
			2: <input type="radio" name="a" value="B" /></td>
			<td id="OptB"></td></tr>
			
			<tr>
			<td>
			3: <input type="radio" name="a" value="C" /></td>
			<td id="OptC"></td></tr>
			
			<tr>
			<td>
			4: <input type="radio" name="a" value="D" /> </td>
			<td id="OptD"></td></tr>
			
			<tr>
			<td>
			<center>
			   <input type="button" value="Next" name="submit" id="submit" onclick="checkSolution()"></center></td></tr>
			</table>
			
			</form>
		 </td>
		 </tr>
		</table>	
	</div>
</div>
<% 
	ArrayList<Question> Qns=new ArrayList<Question>();
	Qns=(ArrayList<Question>)request.getAttribute("QuestionBank");
	JSONArray QnsJson = new JSONArray(Qns);
%>
<script>
	populateQuestions('<%=QnsJson%>');
</script>
</body>
</html>