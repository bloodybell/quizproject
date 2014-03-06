package quizproject.data;

public class OXQuiz extends Quiz {
	private String[] example = new String[2];

	public OXQuiz() {
		super.type = "OXQuiz";
		super.example = new String[2];
		example[0] = "O";
		example[1] = "X";
	}

	@Override
	public String[] getExample() {

		return example;

	}

}
