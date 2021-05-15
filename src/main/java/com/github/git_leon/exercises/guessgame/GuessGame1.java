package com.github.git_leon.exercises.guessgame;

import com.github.git_leon.utils.Console;
import com.github.git_leon.utils.Randomizer;

public class GuessGame1 {
    private final int secretNum;
    private final int min;
    private final int max;

    public GuessGame1() {
        this(1, 10);
    }

    public GuessGame1(int min, int max) {
        this.min = min;
        this.max = max;
        this.secretNum = Randomizer.createInteger(min, max);
    }

    public void playGame() {
        String promptForInput = "Guess the secret number between %s and %s";
        int min = 1;
        int max = 10;
        int tries = 0;
        int previousGuess = -1;
        boolean isCorrect = false;
        while (!isCorrect) {
            int guess = Console.getIntegerInput(promptForInput, min, max);
            if (guess != previousGuess) {
                tries++;
            }
            previousGuess = guess;
            isCorrect = checkGuess(secretNum, guess, tries);
        }
    }

    private boolean checkGuess(int secretNum, int guess, int tries) {
        if (guess == secretNum) {
            Console.print("You got it! It took %s tries.", tries);
            return true;
        } else if (guess > secretNum) {
            Console.print("That's too high!");
        } else {
            Console.print("That's too low!");
        }
        return false;
    }
}