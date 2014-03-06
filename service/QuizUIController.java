package quizproject.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import quizproject.data.Quiz;
import quizproject.ui.DisplayUI;
import quizproject.ui.MultiDisplayUI;
import quizproject.ui.OXDisplayUI;
import quizproject.ui.SubDisplayUI;

public class QuizUIController {
	private Scanner scanner;
	private QuizService service;
	private Map<String, DisplayUI> uiMap;

	public QuizUIController(Scanner scanner, QuizService service) {
		super();
		this.scanner = scanner;
		this.service = service;

		uiMap = new HashMap<String, DisplayUI>();

		uiMap.put("OXQuiz", new OXDisplayUI(service, scanner));
		uiMap.put("MultiQuiz", new MultiDisplayUI(service, scanner));
		uiMap.put("SubQuiz", new SubDisplayUI(service, scanner));
	}

	public void startQuiz() {
		Quiz quiz = null;
		int quizIndex = 0;

		intro();

		while (quizIndex < 10) {
			quiz = service.getQuiz(quizIndex);

			DisplayUI ui = uiMap.get(quiz.getType());
			
			ui.solveQuiz(quizIndex, quiz);
			quizIndex++;
		}

		System.out.printf("최종 점수는 %d 입니다.", service.calcScore());
	}

	private void intro() {
		System.out
				.println("지금부터 퀴즈가 시작 됩니다. 이 퀴즈는 다양한 애니메이션에 대한 문제들로 구성되어 있습니다.\n"
						+ "문제 구성은 OX 2문제, 사지선다 5문제, 주관식 3문제로 이루어져 있습니다.\n"
						+ "문제를 잘 읽고, 답을 해 주시기 바랍니다.\n"
						+ "계속 하시려면 [Enter]를 입력해 주세요.");
		scanner.nextLine();

	}

}
