

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Domain.Question;
import SQL.DBA;

/**
 * Servlet implementation class QuizHome
 */
@WebServlet("/QuizHome")
public class QuizHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuizHome() {
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
		ArrayList<Question> Qns=new ArrayList<Question>();
		DBA db=new DBA();
		HttpSession sh=request.getSession(false);
		Object ob=sh.getAttribute("compid");
		if(ob!=null){
			int companyId=(int)ob;
			System.out.println("Company chosen ="+companyId);
			Qns=db.getQuestions(companyId);
			request.setAttribute("QuestionBank", Qns);
			System.out.println("Qusetionset->"+Qns.toString());
			RequestDispatcher rd = request.getRequestDispatcher("QuizPage.jsp");
			rd.include(request, response);
			
		}else{
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}
		 
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
