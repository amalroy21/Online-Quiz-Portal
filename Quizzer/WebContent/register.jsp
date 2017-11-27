<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
    </head>
    <link href="css/loginStyle.css" rel="stylesheet" type="text/css">
    <body>
    <div class="wrapper">
		
		<form action=Registration method=get class="login">
		<p class="title">Registration</p>
	    <input name="fname" type="text" placeholder="First Name" autofocus/>
	    <i class="fa fa-user"></i>
	    <input name="lname" type="text" placeholder="Last Name" />
	    <i class="fa fa-user"></i>
	    <input name="email" type="text" placeholder="Email" />
	    <i class="fa fa-user"></i>
	    <input name="username" type="text" placeholder="Username" />
	    <i class="fa fa-user"></i>
	    <input name="password" type="password" placeholder="Password" />
	    <i class="fa fa-key"></i>
	    <!-- <a href="resetPassword.jsp">Forgot your password?</a>
    	<select name=role>
			<option value=candidate selected>Candidate</option>
			<option value=company>Company</option>
		</select><br><br> -->
	    <button type="submit">
	      <i class="spinner"></i>
	      <span class="state">Register Now</span>
	    </button>
	    <a href="index.jsp">Already registered? Click here to go to Login Page.</a>
		</form>
	</div>

	<!-- <div class="content">
        <form method="get" action="Registration">
            
            <table border="1" style="width:30%" cellpadding="5">
                <thead>
                    <tr>
                        <th colspan="2">Enter Information Here</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>First Name</td>
                        <td><input type="text" name="fname" value="" /></td>
                    </tr>
                    <tr>
                        <td>Last Name</td>
                        <td><input type="text" name="lname" value="" /></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><input type="text" name="email" value="" /></td>
                    </tr>
                    <tr>
                        <td>User Name</td>
                        <td><input type="text" name="uname" value="" /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="pass" value="" /></td>
                    </tr>
                    <tr>
                    <td>User Role</td>
		            <td><select name=desig>
						<option value=user selected>Candidate</option>
						<option value=admin>Company</option>
					</select><br><br></td>
                    <tr>
                        <td><input type="submit" value="Submit" /></td>
                        <td><input type="reset" value="Reset" /></td>
                    </tr>
                    <tr>
                        <td colspan="2">Already registered!! <a href="index.jsp">Login Here</a></td>
                    </tr>
                </tbody>
            </table>
           
        </form>
        </div> -->
    </body>
</html>