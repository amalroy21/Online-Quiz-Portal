package SQL;

import SQL.JdbcUtil;
import Domain.Question;

import java.sql.Connection;
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
	
}
