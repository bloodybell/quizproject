package quizproject.ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import quizproject.data.MultiQuiz;
import quizproject.data.OXQuiz;
import quizproject.data.Quiz;
import quizproject.data.SubQuiz;
import quizproject.service.QuizService;

public class QuizInsertUI {

	private String text;
	private String answer;
	private QuizService service;

	public QuizInsertUI(QuizService service) {
		super();
		this.service = service;

	}

	public void TextParser() {
		try {
			String tmpQuestion;
			String tmpAnswer;
			File f = new File("src/quizproject/quiz.txt");
			Scanner fScanner = new Scanner(f);
			Quiz q = null;
			while (fScanner.hasNext()) {
				switch (fScanner.nextLine()) {
				case "OX":
					tmpQuestion = fScanner.nextLine().replace("|", "\n");
					tmpAnswer = fScanner.nextLine();
					q = new OXQuiz();

					q.setQuestion(tmpQuestion);
					q.setAnswer(tmpAnswer);
					service.setQuiz(q);

					break;

				case "사지선다":
					tmpQuestion = fScanner.nextLine().replace("|", "\n");
					tmpAnswer = fScanner.nextLine();
					q = new MultiQuiz();
					String[] example = new String[4];

					for (int i = 0; i < 4; i++) {
						example[i] = fScanner.nextLine();
					}

					q.setQuestion(tmpQuestion);
					q.setAnswer(tmpAnswer);
					((MultiQuiz) q).setExample(example);
					service.setQuiz(q);
					break;

				case "주관식":
					tmpQuestion = fScanner.nextLine().replace("|", "\n");
					tmpAnswer = fScanner.nextLine();
					q = new SubQuiz();

					q.setQuestion(tmpQuestion);
					q.setAnswer(tmpAnswer);
					service.setQuiz(q);
					break;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}