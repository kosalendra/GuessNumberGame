package com.sarasvativihar;

import java.util.Scanner;

public class Application {
	public static void main(String[] args) {
		System.out.println("Let's play a numbers guessing game");
		System.out.println("***********************************");

		System.out.println("#######################################################################################");
		System.out.println("##                I'll select a 4 digit number with unique digits                    ##");
		System.out.println("##                   You'll have 10 tries to guess the number                        ##");
		System.out.println("##            Only 4 digit numbers with unique digit will be accepted                ##");
		System.out.println("##   After each guess, I'll tell you how many numbers are correctly guessed(cow)     ##");
		System.out.println("##              and how many numbers are in correct positions(bull)                  ##");
		System.out.println("##              After 10 tries correct number will be displayed                      ##");
		System.out.println("#######################################################################################");

		try (Scanner sc = new Scanner(System.in)) {
			String playAgain = "Y";
			while ("Y".equalsIgnoreCase(playAgain)) {

				NumberGuessService numberGuessService = new NumberGuessService();
				System.out.println("\nSelecting a number for this round...");
				String actualHand = numberGuessService.selectActualHand();
				System.out.println("Number selected");

				System.out.println("Please make a guess. You've 10 tries...");
				while (numberGuessService.getTries() > 0) {
					String newGuess = sc.nextLine();
					if (!numberGuessService.validateInput(newGuess)) {
						System.out.println("Invalid guess made. Please guess again");
						continue;
					}
					Guess guess = new Guess(actualHand, newGuess);
					System.out.println("" + guess);
					if (guess.getCorrectGuess()) {
						System.out.println("######################################################");
						System.out.println("#                   Congratulations                  #");
						System.out.println("#        You have guessed the number correctly       #");
						System.out.println("######################################################");
						System.out.println("");
						System.out.println("Guess: " + guess.getCurrentGuess() + ", ActualHand: " + actualHand);
						System.out.println("\n\n");
						break;
					}
					System.out.println("Tries left: " + numberGuessService.getTries() + "\n");
					if (numberGuessService.getTries() == 0) {
						System.out.println("######################################################");
						System.out.println("#                 All tries exhausted                #");
						System.out.println("#              Actual Number was: " + actualHand +"               #");
						System.out.println("######################################################");
					}
				}
				System.out.println("\nDo you want to play again? Y/n");
				playAgain = sc.nextLine();
			}
			System.out.println("\nThank you for playing");
		}
	}
}
