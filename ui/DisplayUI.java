package quizproject.ui;

import java.util.Scanner;

import quizproject.data.Quiz;
import quizproject.service.QuizService;

public class DisplayUI {
	private QuizService service;
	private Scanner scanner;
	private Quiz quiz;

	public DisplayUI(QuizService service, Scanner scanner) {
		super();
		this.service = service;
		this.scanner = scanner;
	}

	private void printQuestion() {
		System.out.println(quiz.getQuestion());
	}

	private void printExample() {
		String[] examples = quiz.getExample();

		if (quiz.getExample() != null) {
			int count = 1;
			for (String example : examples) {
				System.out.println((count++) + ". " + example);
			}
		}
	}

	private void doAnswer(int quizIndex) {
		boolean result = false;
		String userAnswer = "";

		do {
			service.isChance = false;

			System.out.print("���� �Է����ּ���. : ");
			userAnswer = scanner.nextLine();

			if (userAnswer.equals("C")) {
				if (service.chanceCount > 0) {
					service.useChance();
					System.out.printf("������ ����߽��ϴ�. ���� ���� �� : %d\n",
							service.chanceCount);
				} else {
					System.out.println("���� ������ �����ϴ�.");
					service.useChance();
				}
				System.out.print("���� �Է����ּ���. : ");
				userAnswer = scanner.nextLine();

			}

			result = quiz.isAnswer(userAnswer);
		} while (service.isChance && !result);

		if (result) {
			System.out.println("�����Դϴ�.");
		} else {
			System.out.println("Ʋ�Ƚ��ϴ�.");
		}

		// ������ ���� ������ ����Ѵ�.
		service.setAnswerSheet(quizIndex, result);

		return;
	}

	public void solveQuiz(int quizIndex, Quiz quiz) {
		this.quiz = quiz;
		printQuestion();
		printExample();

		doAnswer(quizIndex);
	}

}
