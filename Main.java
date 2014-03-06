package quizproject;

import java.util.Scanner;

import quizproject.service.QuizService;
import quizproject.service.QuizUIController;
import quizproject.ui.QuizInsertUI;

public class Main {


	public static void main(String[] args) {
		QuizService service = new QuizService();
		Scanner scanner = new Scanner(System.in);
		
		QuizUIController controller = new QuizUIController(scanner, service);
		QuizInsertUI insertUI = new QuizInsertUI(service);
		
		insertUI.TextParser();
		controller.startQuiz();
		
	}

}
