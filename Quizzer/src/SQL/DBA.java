package SQL;

import SQL.JdbcUtil;
import Domain.Company;
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
	
	public ArrayList<Question> getQuestions(int companyId){
		
		ArrayList<Question> Qn=new ArrayList<Question>();
		Question quest=null;
		try {
			st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from QUESTIONBANK where rownum<=5 and companyid="+companyId);
			while(rs.next())
			{
				quest=new Question();
				quest.setQuestion(rs.getString(2));
				quest.setOptionA(rs.getString(3));
				quest.setOptionB(rs.getString(4));
				quest.setOptionC(rs.getString(5));
				quest.setOptionD(rs.getString(6));
				quest.setAnswer(rs.getString(7));
				/*quest.setQnType(rs.getString(8));
				quest.setQnLevel(""+rs.getInt(9));
				quest.setCompanyId(rs.getInt(10));*/
				//System.out.println("Db Access for Questions is fine");
				Qn.add(quest);
			}
			
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Qn;
		
	}
	
	public boolean insertQuestion(Question qn){
		boolean status=false;
		int flag=-1;
		int token=0;
		try {
			st=con.createStatement();
			ResultSet rs=st.executeQuery("select max(token) from Questionbank");
			
			while(rs.next())
			{
				token=rs.getInt(1)+1;
			}
			st.close();
			
			String sql="insert into Questionbank(token, question,optiona, optionb, optionc, optiond, answer, qntype,qnlevel,companyid) "
					+ "values (?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1, token);
			stmt.setString(2, qn.getQuestion());
			stmt.setString(3, qn.getOptionA());
			stmt.setString(4, qn.getOptionB());
			stmt.setString(5, qn.getOptionC());
			stmt.setString(6, qn.getOptionD());
			stmt.setString(7, qn.getAnswer());
			stmt.setString(8, qn.getQnType());
			stmt.setString(9, qn.getQnLevel());
			stmt.setInt(10, qn.getCompanyId());
			
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
	
	public boolean createNewUser(String fname, String lname, String email,String user,String pwd,String role){
		boolean status=false;
		int flag=-1;
		try {
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
			}else{
				if("company".equalsIgnoreCase(role)){
					id=getCompany(email);
				}
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id;
	}
	
	public ArrayList<QuizResults> getResults(int candidateid,String role){
		int id=-1;
		
		ArrayList<QuizResults> QrsList=new ArrayList<QuizResults>();
		QuizResults qrs=null;
		try {
			
			st=con.createStatement();
			StringBuffer sql=new StringBuffer();
			sql.append("select * from quizresults where");
			
			if("company".equalsIgnoreCase(role)){
				sql.append(" companyid='"+candidateid+"'");
			}else{
				sql.append(" candidateid='"+candidateid+"'");
			}
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
	
	public int getCompany(String email){
			
			int id=-1;
			try{
				st=con.createStatement();
				StringBuffer sql=new StringBuffer();
				sql.append("select id from company where");
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
	
	public String getCompanyName(int id){
		
		String name="";
		try{
			st=con.createStatement();
			StringBuffer sql=new StringBuffer();
			sql.append("select name from company where");
			sql.append(" id='"+id+"'");
			ResultSet rs=st.executeQuery(sql.toString());
			
			while(rs.next())
			{
				name=rs.getString(1);
			}
			st.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return name;
	}
	
	public String getCandidateName(int id){
		
		String name="";
		try{
			st=con.createStatement();
			StringBuffer sql=new StringBuffer();
			sql.append("select name from candidate where");
			sql.append(" id='"+id+"'");
			ResultSet rs=st.executeQuery(sql.toString());
			
			while(rs.next())
			{
				name=rs.getString(1);
			}
			st.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return name;
	}
	
	public ArrayList<Company> searchCompany(String compKey,String locKey){
			
			int flag=0;
			ArrayList<Company> comp_List=new ArrayList<Company>();
			try{
				st=con.createStatement();
				StringBuffer sql=new StringBuffer();
				sql.append("select * from company where");
				if(!"".equals(compKey)){
					sql.append(" lower(name) like '%"+compKey.toLowerCase()+"%'");
					flag=1;
				}
				if(!"".equals(locKey)){
					if(flag==1){
						sql.append(" OR ");
					}
					sql.append(" lower(city) like '%"+locKey.toLowerCase()+"%'");
					sql.append(" OR lower(state) like '%"+locKey.toLowerCase()+"%'");
					flag=1;
				}
				if(flag==1){
					ResultSet rs=st.executeQuery(sql.toString());
					
					while(rs.next())
					{
						Company c=new Company();
						c.setId(rs.getInt(1));
						c.setName(rs.getString(2));
						c.setDescription(rs.getString(3));
						c.setEmail(rs.getString(4));
						c.setPhone(rs.getString(5));
						c.setCity(rs.getString(6));
						c.setState(rs.getString(7));
						c.setZip(rs.getString(8));
						System.out.println("Company Name "+c.getName());
						
						comp_List.add(c);
					}
				}
				else{
					comp_List=searchCompanyAll();
				}
				st.close();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return comp_List;
		}
	
	public ArrayList<Company> searchCompanyAll(){
		
		int flag=0;
		ArrayList<Company> comp_List=new ArrayList<Company>();
		try{
			st=con.createStatement();
			StringBuffer sql=new StringBuffer();
			sql.append("select * from company where rownum<=10");
			ResultSet rs=st.executeQuery(sql.toString());
			
			while(rs.next())
			{
				Company c=new Company();
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setDescription(rs.getString(3));
				c.setEmail(rs.getString(4));
				c.setPhone(rs.getString(5));
				c.setCity(rs.getString(6));
				c.setState(rs.getString(7));
				c.setZip(rs.getString(8));
				System.out.println("Company Name "+c.getName());
				
				comp_List.add(c);
			}
			st.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return comp_List;
	}
	
	public Company getCompanyDetails(int id){
			
			Company c=new Company();
			
			try{
				st=con.createStatement();
				StringBuffer sql=new StringBuffer();
				sql.append("select * from company where");
				sql.append(" id='"+id+"'");
				ResultSet rs=st.executeQuery(sql.toString());
				
				while(rs.next())
				{
					c.setId(rs.getInt(1));
					c.setName(rs.getString(2));
					c.setDescription(rs.getString(3));
					c.setEmail(rs.getString(4));
					c.setPhone(rs.getString(5));
					c.setCity(rs.getString(6));
					c.setState(rs.getString(7));
					c.setZip(rs.getString(8));
				}
				st.close();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return c;
		}
	
	
}
