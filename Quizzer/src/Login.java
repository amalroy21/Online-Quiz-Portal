

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import SQL.DBA;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String role=request.getParameter("role");
		HttpSession sh=request.getSession();
		
		DBA DB=new DBA();
		int id=-1;
		id=DB.getUser(username, password, role);
		sh.setAttribute("id", id);
		System.out.println("id="+id);
		String name="";
		if(id==-1){
			sh.setAttribute("username", username);
			sh.setAttribute("userid",id);
			response.sendRedirect("index.jsp?valid=false");
		}else if("company".equalsIgnoreCase(role)){
			response.sendRedirect("companyHome.jsp");
			name=DB.getCompanyName(id);
		}else{
			response.sendRedirect("userHome.jsp");
			name=DB.getCandidateName(id);
		}
		sh.setAttribute("name", name);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
