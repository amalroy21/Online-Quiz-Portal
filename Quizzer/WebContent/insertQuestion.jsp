<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TECHNO-CRUNCH</title>
<script>
function validateForm(theForm){
	if(theForm.quest.value==""){
		alert("Please enter Question.");
		theForm.quest.focus();
		return false;
	}
	return true;
} 
</script>
</head>
<body>
<br>
<br/>
<div id="leftSideBar">
    <jsp:include page="leftSideBarComp.jsp"/>
</div>
<div class="content" style="float:left">
<center>

<table border="1" width="450px" bgcolor="dimgrey" cellspacing="0" cellpadding="0">
  <tr>
    <td width="100%">
      <form method="POST" action="PopulateQBank" onsubmit="return validateForm(this);">
     
        <h2 align="center"><font color="red">Question Bank</font></h2>
        <table border="0" width="400px" cellspacing="2" cellpadding="4">
          <tr>
            <td width="50%"><b>Enter Question:</b></td>
            <td width="50%"><input type="text" name="quest" size="40"/> </td>
          </tr>
	<tr>
            <td width="50%"><b>Enter Answer(A.):</b></td>
            <td width="50%"><input type="text" name="QA" size="40"/> </td>
          </tr>
	 <tr>
            <td width="50%"><b>Enter Answer(B.):</b></td>
            <td width="50%"><input type="text" name="QB" size="40"/> </td>
          </tr>

          <tr>
            <td width="50%"><b>Enter Answer(C.):</b></td>
            <td width="50%"><input type="text" name="QC" size="40"/> </td>
          </tr>

	<tr>
            <td width="50%"><b>Enter Answer(D.):</b></td>
            <td width="50%"><input type="text" name="QD" size="40"/> </td>
          </tr>
	 
	<tr>
            <td width="50%"><b>Correct Option:</b></td>
            <td width="50%"><select name=correctAns>
				<option value=A selected>Option A</option>
				<option value=B >Option B</option>
				<option value=C >Option C</option>
				<option value=D >Option D</option>
			</select><br><br> </td>
          </tr>	
          
          <tr>
            <td width="50%"><b>Question Level</b></td>
            <td width="50%"><select name=level>
				<option value="1" selected>1</option>
				<option value="2" >2</option>
				<option value="3" >3</option>
			</select><br><br> </td>
          </tr>	
          
          

        </table>
	<center>
        <p><input type="submit" value="Submit" name="submit">
          <input type="reset" value="Reset" name="reset"></p>
        </center>  
      </form>
    </td>
  </tr>
</table>
</center>
</div>
</body>
</html>