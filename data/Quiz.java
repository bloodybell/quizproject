package quizproject.data;

public abstract class Quiz {

	protected String type;
	protected String question;
	protected String answer;
	protected String[] example;

	public abstract String[] getExample();

	public Quiz() {
		super();
	}

	public boolean isAnswer(String answer) {
		return this.answer.equals(answer);
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getType() {
		return this.type;
	}
	
		
}