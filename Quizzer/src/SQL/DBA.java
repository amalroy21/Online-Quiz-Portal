package SQL;

import SQL.JdbcUtil;
import Domain.Question;
import Domain.QuizResults;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class DBA {

	private static Connection con;
	private Statement st;
	
	public DBA(){
		con=null;
		st=null;
		
		try {
			con=JdbcUtil.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Date getDate() throws SQLException{
		Date sysdate=null;
		st=con.createStatement();
		ResultSet rs=st.executeQuery("select sysdate from Dual");
		while(rs.next())
		{
			sysdate=rs.getDate(1);
		}
		st.close();
		return sysdate;
		
	}
	
	public ArrayList<Question> getQuestions(){
		
		ArrayList<Question> Qn=new ArrayList<Question>();
		Question quest=null;
		try {
			st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from QUESTIONBANK where rownum<=5");
			while(rs.next())
			{
				quest=new Question();
				quest.setQuestion(rs.getString(2));
				quest.setOptionA(rs.getString(3));
				quest.setOptionB(rs.getString(4));
				quest.setOptionC(rs.getString(5));
				quest.setOptionD(rs.getString(6));
				quest.setAnswer(rs.getString(7));
				
				Qn.add(quest);
			}
			
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Qn;
		
	}
	
	public boolean createNewUser(String fname, String lname, String email,String user,String pwd,String role){
		boolean status=false;
		int flag=-1;
		try {
			//insert into userdetails (emailid,firstname,lastname,username,password,user_role,regdate)
			//values("amal.roy@utdallas.edu","Amal","Roy","amalroy","123456","admin",to_date ('21-OCT-2017','DD-MON-YYYY'));
			String sql="insert into userdetails(emailid,firstname,lastname,username,password,user_role,regdate) "
					+ "values (?,?,?,?,?,?,?)";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1, email);
			stmt.setString(2, fname);
			stmt.setString(3, lname);
			stmt.setString(4, user);
			stmt.setString(5, pwd);
			stmt.setString(6,role);
			stmt.setDate(7, (java.sql.Date) getDate());
			
			flag=stmt.executeUpdate();
			if(flag>0){
				status=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}
	
	public boolean createCandidate(String name,String email,String phone){
		boolean status=false;
		int flag=-1;
		int id=1;
		try {
			
			st=con.createStatement();
			ResultSet rs=st.executeQuery("select max(id) from candidate");
			
			while(rs.next())
			{
				id=rs.getInt(1)+1;
			}
			st.close();
			
			String sql="insert into candidate(id,name,email,phone) "
					+ "values (?,?,?,?)";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.setString(2, name);
			stmt.setString(3, email);
			stmt.setString(4, phone);
			
			flag=stmt.executeUpdate();
			if(flag>0){
				status=true;
			}
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}
	
	public boolean createCompany(String name,String email,String phone,String description){
		boolean status=false;
		int flag=-1;
		int id=1;
		try {
			
			st=con.createStatement();
			ResultSet rs=st.executeQuery("select max(id) from company");
			
			while(rs.next())
			{
				id=rs.getInt(1)+1;
			}
			st.close();
			
			String sql="insert into company(id,name,email,phone,description) "
					+ "values (?,?,?,?,?)";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.setString(2, name);
			stmt.setString(3, email);
			stmt.setString(4, phone);
			stmt.setString(5,description);
			
			flag=stmt.executeUpdate();
			if(flag>0){
				status=true;
			}
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}
	
	public boolean insertResult(int candidateid,int companyid,int score,int level,int total){
		boolean status=false;
		int flag=-1;
		try {
			
			String sql="insert into quizresults(companyid,candidateid,score,qlevel,total,eventdate) "
					+ "values (?,?,?,?,?,?)";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1, companyid);
			stmt.setInt(2, candidateid);
			stmt.setInt(3, score);
			stmt.setInt(4, level);
			stmt.setInt(5, total);
			stmt.setDate(6, (java.sql.Date) getDate());
			flag=stmt.executeUpdate();
			if(flag>0){
				status=true;
			}
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}
	
	public int getUser(String username,String password,String role){
		int id=-1;
		String email="";
		boolean flag=false;
		try {
			
			st=con.createStatement();
			StringBuffer sql=new StringBuffer();
			sql.append("select emailid from userdetails where");
			sql.append(" username='"+username+"'");
			sql.append(" and password='"+password+"'");
			ResultSet rs=st.executeQuery(sql.toString());
			
			while(rs.next())
			{
				email=rs.getString(1);
				flag=true;
			}
			st.close();
			if(flag==true && "candidate".equalsIgnoreCase(role)){
				id=getCandidate(email);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id;
	}
	
	public ArrayList<QuizResults> getResults(int candidateid){
		int id=-1;
		
		ArrayList<QuizResults> QrsList=new ArrayList<QuizResults>();
		QuizResults qrs=null;
		try {
			
			st=con.createStatement();
			StringBuffer sql=new StringBuffer();
			sql.append("select * from quizresults where");
			sql.append(" candidateid='"+candidateid+"'");
			
			ResultSet rs=st.executeQuery(sql.toString());
			
			while(rs.next())
			{
				qrs=new QuizResults();
				qrs.setCandidateid(rs.getInt(1));
				qrs.setCompanyid(rs.getInt(2));
				qrs.setScore(rs.getInt(3));
				qrs.setQlevel(rs.getInt(4));
				qrs.setEventdate(rs.getDate(5));
				qrs.setTotal(rs.getInt(6));
				
				QrsList.add(qrs);
			}
			st.close();
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return QrsList;
	}
	
	
	
	
	
	public int getCandidate(String email){
		
		int id=-1;
		try{
			st=con.createStatement();
			StringBuffer sql=new StringBuffer();
			sql.append("select id from candidate where");
			sql.append(" email='"+email+"'");
			ResultSet rs=st.executeQuery(sql.toString());
			
			while(rs.next())
			{
				id=rs.getInt(1);
			}
			st.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id;
	}
	
}
