

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import SQL.DBA;

/**
 * Servlet implementation class ResultController
 */
@WebServlet("/ResultController")
public class ResultController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResultController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.sendRedirect("Result.jsp?score=600");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		DBA db=new DBA();
		String data="";
		data="id="+request.getParameter("companyid")+":score="+request.getParameter("score");
		data+=":level="+request.getParameter("qnlevel")+":total="+request.getParameter("total");
		System.out.println(data);
		HttpSession sh=request.getSession(false);
		Object ob=sh.getAttribute("compid");
		int companyid=0;
		if(ob!=null){
			companyid=(int)ob;
		}
		
		int score=Integer.parseInt(request.getParameter("score"));
		int level=Integer.parseInt(request.getParameter("qnlevel"));
		int total=Integer.parseInt(request.getParameter("total"));
		
	    int candidateid=(int) sh.getAttribute("id");  
		System.out.println("id="+companyid);
		boolean createStatus= db.insertResult(candidateid,companyid, score, level, total);
	    if (createStatus) {
	        //session.setAttribute("userid", user);
	        //response.sendRedirect("index.jsp");
	       pw.print("Quiz Completed successfully!");
	    } else {
	    	pw.println("Failure");
	    }
		//pw.print("Success!");
	}

}
