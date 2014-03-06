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

			System.out.print("답을 입력해주세요. : ");
			userAnswer = scanner.nextLine();

			if (userAnswer.equals("C")) {
				if (service.chanceCount > 0) {
					service.useChance();
					System.out.printf("찬스를 사용했습니다. 남은 찬스 수 : %d\n",
							service.chanceCount);
				} else {
					System.out.println("남은 찬스가 없습니다.");
					service.useChance();
				}
				System.out.print("답을 입력해주세요. : ");
				userAnswer = scanner.nextLine();

			}

			result = quiz.isAnswer(userAnswer);
		} while (service.isChance && !result);

		if (result) {
			System.out.println("정답입니다.");
		} else {
			System.out.println("틀렸습니다.");
		}

		// 문제의 정답 유무를 기록한다.
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
