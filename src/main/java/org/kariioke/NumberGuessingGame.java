package org.kariioke;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class NumberGuessingGame {
    static void main() {
        //guess my number

        Scanner scanner = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 100");
        int myNumber = (int)(Math.random() * 100) + 1;


        System.out.println("You have several chances depending on the difficulty you choose");
        System.out.println(" ");


        System.out.println("Please select the level if difficulty: ");
        System.out.println("1. Easy (10 chances)");
        System.out.println("2. Medium (5 chances)");
        System.out.println("3. Hard (3 chances)");
        System.out.println(" ");


        System.out.print("Enter your choice: ");
        int difficulty = scanner.nextInt();
        System.out.println(" ");

        String level = difficulty(difficulty);

        System.out.println(difficultyMessage(level));
        int guesses = guess(level);
        System.out.println("You'll have " +  guesses + " guesses.");
        System.out.println("Let's start the game!");
        System.out.println(" ");


        guessGame(level);

    }

    static String difficulty(int difficulty) {
        String difficultyLevel = "";
        if(difficulty == 1) {
            difficultyLevel = "Easy";
        }
        if (difficulty == 2) {
            difficultyLevel ="Medium";
        }
        if (difficulty == 3) {
            difficultyLevel = "Hard";
        }

        return difficultyLevel;
    }

    static int guess(String level) {
        int guesses = 0;
        if (level == "Easy") {
            guesses = 10;
        } else if (level == "Medium") {
            guesses = 5;
        } else if (level == "Hard") {
            guesses = 3;
        } else guesses = 0;

        return guesses;
    }

    static String difficultyMessage(String level) {
        String message;
        if (level == "Easy" || level == "Medium" || level == "Hard") {
            message = "Great! You have selected the " + level + " difficulty level.";
        } else message = "Invalid difficulty chosen";
        return message;
    }

    static void guessGame(String level) {
            Scanner scanner = new Scanner(System.in);
            int number = ThreadLocalRandom.current().nextInt(1, 101);
            System.out.println(number);
            int guesses = guess(level);
            int guessCount = 0;

            if(guesses == 0) {
                System.out.println("You have zero guesses for the game");
            }

            if (guesses != 0 && guessCount < guesses) {
                for (int i = 0; i < guesses; i++) {
                    System.out.print("Enter your guess: ");
                    int yourGuess = scanner.nextInt();
                    if (guessCount < guesses) {
                        if(yourGuess < number) {
                            System.out.println("Incorrect! The number is greater than " + yourGuess);
                        } else if(yourGuess > number) {
                            System.out.println("Incorrect! The number is less than " + yourGuess);
                        } else if(yourGuess == number) {
                            System.out.println("Congratulations!, You guessed the correct number in " + (i + 1) + " attempts");
                        }
                    }
                    guessCount++;
                }
            }
    }
}
