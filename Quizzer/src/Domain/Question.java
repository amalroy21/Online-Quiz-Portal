package Domain;

public class Question {

	private String Question;
	private String OptionA;
	private String OptionB;
	private String OptionC;
	private String OptionD;
	private String Answer;
	private String QnType;
	private String QnLevel;
	private int QuestionNo;
	private int companyId;

	public Question() {
		super();
		Question = "";
		OptionA  = "";
		OptionB  = "";
		OptionC  = "";
		OptionD  = "";
		Answer   = "";
		QnType   = "";
		QnLevel  = "";
		QuestionNo=0;
		companyId=0;
	}
	
	public int getQuestionNo() {
		return QuestionNo;
	}

	public void setQuestionNo(int questionNo) {
		QuestionNo = questionNo;
	}

	public String getQuestion() {
		return Question;
	}

	public void setQuestion(String question) {
		Question = question;
	}

	public String getOptionA() {
		return OptionA;
	}

	public void setOptionA(String optionA) {
		OptionA = optionA;
	}

	public String getOptionB() {
		return OptionB;
	}

	public void setOptionB(String optionB) {
		OptionB = optionB;
	}

	public String getOptionC() {
		return OptionC;
	}

	public void setOptionC(String optionC) {
		OptionC = optionC;
	}

	public String getOptionD() {
		return OptionD;
	}

	public void setOptionD(String optionD) {
		OptionD = optionD;
	}

	public String getAnswer() {
		return Answer;
	}

	public void setAnswer(String answer) {
		Answer = answer;
	}

	public String getQnType() {
		return QnType;
	}

	public void setQnType(String qnType) {
		QnType = qnType;
	}

	public String getQnLevel() {
		return QnLevel;
	}

	public void setQnLevel(String qnLevel) {
		QnLevel = qnLevel;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	
}
