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
	<form action=QuizHome name="StartQz" onsubmit="return confirm('Are you sure you want to start now');">
		
		<span>Please Read the instructions carefully before attempting the quiz.</span>
		<ol>
		<li>The quiz consists of 5 multiple choice questions that are worth 1 point each.</li>
		<li>You have 10 minutes to answer all 5 questions.</li>
		<li>You must complete the entire quiz in one session as you are not allowed to leave the quiz and then return.</li>
		<li>To begin with the quiz, click on the "ATTEMPT QUIZ NOW" button.</li>
		<li>You will be prompted to verify that you are ready to start your quiz. </li>
		<li>Once you choose "START ATTEMPT' you have 10 minutes total to complete and SUBMIT the quiz for grading.</li>
		<li>Make sure you answer each question on the page before you click on NEXT; you will not be able to go back. Choosing NEXT automatically saves your answers.</li>
		</ol>
		<input type=submit value="Attempt Quiz Now" />
	</form>
</div>
<br>
<br/>
<center>


</center>
</body>

</html>