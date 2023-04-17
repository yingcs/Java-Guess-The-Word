package game;

import java.util.Scanner;

public class GuessTheWord {
	private boolean play = true;
	private Words randomWord = new Words();
	private Scanner scanner = new Scanner(System.in);
	private int roundsLeft = 10;
	char lastRound;

	public void start() {
		do {
			showWord();
			getInput();
			checkInput();
		} while (play);
	}

	private void checkInput() {
		var isGuessedRight = randomWord.guess(lastRound);
		if (isGuessedRight) {
			if (randomWord.isGuessRight()) {
				System.out.println("Congrats! you've won!");
				System.out.println("The word is: '" + randomWord + "'");
				play = false;
			}
		} else {
			roundsLeft--;
			if (roundsLeft == 0) {
				System.out.println("Game over :(");
				play = false;
			}
		}
	}

	private void getInput() {
		// TODO Auto-generated method stub
		System.out.println("Please enter a letter to guess the word: ");
		String userGuess = scanner.nextLine();
		lastRound = userGuess.charAt(0);

		// randomWord.guess(userGuess.charAt(0));

	}

	private void showWord() {
		// TODO Auto-generated method stub
		System.out.println("You have " + roundsLeft + " tries left");
		System.out.println(randomWord);
	}

	public void end() {
		scanner.close();
	}
}
