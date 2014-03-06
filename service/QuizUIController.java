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

		System.out.printf("���� ������ %d �Դϴ�.", service.calcScore());
	}

	private void intro() {
		System.out
				.println("���ݺ��� ��� ���� �˴ϴ�. �� ����� �پ��� �ִϸ��̼ǿ� ���� ������� �����Ǿ� �ֽ��ϴ�.\n"
						+ "���� ������ OX 2����, �������� 5����, �ְ��� 3������ �̷���� �ֽ��ϴ�.\n"
						+ "������ �� �а�, ���� �� �ֽñ� �ٶ��ϴ�.\n"
						+ "��� �Ͻ÷��� [Enter]�� �Է��� �ּ���.");
		scanner.nextLine();

	}

}
