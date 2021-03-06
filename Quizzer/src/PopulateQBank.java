
 
import java.io.IOException;
import java.io.PrintWriter;
 



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Domain.Question;
import SQL.DBA;
 
@WebServlet("/PopulateQBank")
public class PopulateQBank extends HttpServlet {
 
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
         
    	int companyId=0;
    	HttpSession sh=request.getSession();
    	Object ob=sh.getAttribute("id");
    	if(ob!=null){
    		companyId=(int)ob;
    	}
        // read form fields
        String question = request.getParameter("quest");
        String optionA = request.getParameter("QA");
        String optionB = request.getParameter("QB");
        String optionC = request.getParameter("QC");
        String optionD = request.getParameter("QD");
        String correctAnswer = request.getParameter("correctAns");
        String qLevel = request.getParameter("level");
        
        Question questionObj=new Question();
        
        questionObj.setQuestion(question);
        questionObj.setOptionA(optionA);
        questionObj.setOptionB(optionB);
        questionObj.setOptionC(optionC);
        questionObj.setOptionD(optionD);
        questionObj.setAnswer(correctAnswer);
        questionObj.setQnLevel(qLevel);
        questionObj.setQnType("MC");
        questionObj.setCompanyId(companyId);
        
        DBA db =new DBA();
        
        boolean flag=false;
        flag=db.insertQuestion(questionObj);
        
        System.out.println("Question: " + question);
        System.out.println("Option A: " + optionA);
        System.out.println("Option B: " + optionB);
        System.out.println("Option C: " + optionC);
        System.out.println("Option D: " + optionD);
 
        // do some processing here...
         
        // get response writer
        //PrintWriter writer = response.getWriter();
         
        // build HTML code
        /*String htmlRespone = "<html>";
        htmlRespone += "<body><p>Question: " + question + "</p>";
        htmlRespone += "<p>Option A: " + optionA + "</p>";
        htmlRespone += "<p>Option B: " + optionB + "</p>";
        htmlRespone += "<p>Option C: " + optionC + "</p>";
        htmlRespone += "<p>Option D: " + optionD + "</p>";
        htmlRespone += "<p>Correct Answer: " + correctAnswer + "</p></body>";
        htmlRespone += "</html>";
         
        // return response
        
        writer.println(htmlRespone);*/
        response.sendRedirect("QuestionSubmitSuccess.jsp");
        
         
    }
 
}
