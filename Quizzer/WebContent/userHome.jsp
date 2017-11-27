<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TECHNO-CRUNCH</title>
</head>
<link href="css/loginStyle.css" rel="stylesheet" type="text/css">
<body>
<div id="leftbar">
    <jsp:include page="leftSideBar.jsp"/>
</div>
<div class="content login" style="float:left">
	<center>
	<form action="ViewCompanyController" method="get" name="companysearch" id="companysearch" >
        <table><tbody>
        	<tr><td class="npb"><label for="what" id="what_label_top" >Company Name</label></td></tr>
	        <tr><td ><span class="inwrap"><input class="input_text" maxlength="512" size="31"  name="compKey"  id="compKey"></span><div style="width:250px"><!-- --></div></td></tr>
			<tr><td class="npb" colspan="2"><label for="where" id="where_label_top" >Company Location</label></td></tr>
			<tr><td ><span class="inwrap"><input class="input_text" maxlength="64" size="27"  name="locKey"  id="locKey" value=""></span><div style="width:200px"></div></td></tr>
			<tr><td  style="width:1px"><input id="fj" style="background:#2196F3" type="submit" class="input_submit" value="Find Company"></td></tr>
	 </tbody>
	 </table>
	 </form>
	 </center>	
	 </div>              	


</body>

</html>