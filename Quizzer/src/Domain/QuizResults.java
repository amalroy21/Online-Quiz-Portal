package Domain;

import java.util.Date;

public class QuizResults {
	private int candidateid;
	private int score;
	private int companyid;
	private int qlevel;
	private Date eventdate;
	private int total;
	
	
	public int getCandidateid() {
		return candidateid;
	}
	public void setCandidateid(int candidateid) {
		this.candidateid = candidateid;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getCompanyid() {
		return companyid;
	}
	public void setCompanyid(int companyid) {
		this.companyid = companyid;
	}
	public int getQlevel() {
		return qlevel;
	}
	public void setQlevel(int qlevel) {
		this.qlevel = qlevel;
	}
	public Date getEventdate() {
		return eventdate;
	}
	public void setEventdate(Date eventdate) {
		this.eventdate = eventdate;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
}
