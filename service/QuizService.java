package quizproject.service;

import java.util.ArrayList;

import quizproject.data.Quiz;

public class QuizService {	

	private static final int SCORE = 10;

	private ArrayList<Quiz> quizList = new ArrayList<Quiz>();;
	// boolean 기본값은 false
	boolean answerSheet[] = new boolean[10];
	
	public boolean isChance;
	public int chanceCount = 1;

	public void setAnswerSheet(int quizIndex, boolean isCorrect) {
		
		answerSheet[quizIndex] = isCorrect;
	}
	
	public Quiz getQuiz(int quizIndex) {
		return quizList.get(quizIndex);
	}
	
	public void setQuiz(Quiz quiz) {
		quizList.add(quiz);
	}
	
	public void useChance() {
		isChance = true;
		chanceCount--;
		
	}
	

	public int calcScore() {
		int result = 0;
		for (boolean answer : answerSheet) {
			if(answer) {
				result += SCORE;
			}
		}
		
		return result;
	}
	
	
	
}