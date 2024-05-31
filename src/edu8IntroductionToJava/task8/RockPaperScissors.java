package edu8IntroductionToJava.task8;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] choices = {"rock", "paper", "scissors"};
        int userScore = 0;
        int computerScore = 0;

        while (true) {
            System.out.print("Enter rock, paper, or scissors (or 'quit' to stop): ");
            String userChoice = scanner.nextLine().toLowerCase();
            if (userChoice.equals("quit")) {
                break;
            }
            if (!userChoice.equals("rock") && !userChoice.equals("paper") && !userChoice.equals("scissors")) {
                System.out.println("Invalid choice. Try again.");
                continue;
            }

            String computerChoice = choices[random.nextInt(3)];
            System.out.println("Computer chose: " + computerChoice);

            if (userChoice.equals(computerChoice)) {
                System.out.println("It's a tie!");
            } else if ((userChoice.equals("rock") && computerChoice.equals("scissors")) ||
                    (userChoice.equals("paper") && computerChoice.equals("rock")) ||
                    (userChoice.equals("scissors") && computerChoice.equals("paper"))) {
                System.out.println("You win!");
                userScore++;
            } else {
                System.out.println("You lose!");
                computerScore++;
            }

            System.out.println("Score: You " + userScore + " - " + computerScore + " Computer");
        }

        System.out.println("Final score: You " + userScore + " - " + computerScore + " Computer");
        System.out.println("Thanks for playing!");
    }
}

