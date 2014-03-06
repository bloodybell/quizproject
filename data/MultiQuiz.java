package quizproject.data;

public class MultiQuiz extends Quiz {
	String[] example = new String[4];
	
	public MultiQuiz() {
		super.type = "MultiQuiz";
	}
	public String[] getExample() {
		return example;
	}

	public void setExample(String[] example) {
		this.example = example;
	}

}
