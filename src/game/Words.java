package game;

import java.util.Random;

public class Words {
	private String[] randomwords = { "animal", "happiness", "whatever", "good", "awesome" };
	private String selectedWord;
	private Random random = new Random();
	private char[] letters;

	public Words() {
		selectedWord = randomwords[random.nextInt(randomwords.length)];
		letters = new char[selectedWord.length()];
	}

	public String toString() {
		StringBuilder word = new StringBuilder();
		// letters[2] = 'a';

		for (char letter : letters) {
			word.append((letter == '\u0000') ? "- " : letter + " ");
		}

		return word.toString();
	}

	public boolean isGuessRight() {
		for (char letter : letters) {
			if (letter == '\u0000') {
				return false;
			}
		}
		return true;
	}

	public boolean guess(char letter) {
		var isGuessedRight = false;
		for (int i = 0; i < selectedWord.length(); i++) {
			if (letter == selectedWord.charAt(i)) {
				letters[i] = letter;
				isGuessedRight = true;
			}
		}
		return isGuessedRight;
	}
}
