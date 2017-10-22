

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SQL.DBA;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String user = request.getParameter("uname");    
	    String pwd = request.getParameter("pass");
	    String fname = request.getParameter("fname");
	    String lname = request.getParameter("lname");
	    String email = request.getParameter("email");
	    //String role=request.getParameter("role");
	    String role="candidate";
	    String phone="1234567890";
	    String description="Company ideals !";
	    
	    DBA db=new DBA();
	    
	    boolean createStatus= db.createNewUser(fname, lname, email, user, pwd, role);
	    if (createStatus) {
	        //session.setAttribute("userid", user);
	        //response.sendRedirect("index.jsp");
	       pw.print("Registration Successfull!"+"<a href='index.jsp'>Go to Login</a>");
	    } else {
	    	pw.println("Registration Failed!"+"<a href='index.jsp'>Go to Login</a>");
	    	pw.println("<a href='register.jsp'>Try register again !</a>");
	    	//response.sendRedirect("index.jsp");
	    }
	    if(role.equalsIgnoreCase("candidate")){
	    	createStatus=db.createCandidate(fname+" "+lname,email, phone);
	    }else if(role.equalsIgnoreCase("company")){
	    	createStatus=db.createCompany(fname+" "+lname,email, phone,description);
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
