package com.softserve.edu.introToJava.task8;

import java.util.Random;
import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        String[] choiese = {"rock", "paper", "scissors" };
        System.out.println("Choose one of the following options:");
        System.out.println("0. rock");
        System.out.println("1. paper");
        System.out.println("2. scissors");
        int choice = sc.nextInt();
        switch (choice) {
            case 0:
                System.out.println("You chose rock\n");
                break;
            case 1:
                System.out.println("You chose paper\n");
                break;
            case 2:
                System.out.println("You chose scissors\n");
                break;
            default:
                System.out.println("Invalid choice\n");
                break;
        }
        int computerChoice = rand.nextInt(3);
        if (computerChoice == 0) {
            System.out.println("Computer chose rock\n");
        } else if (computerChoice == 1) {
            System.out.println("Computer chose paper\n");
        } else if (computerChoice == 2) {
            System.out.println("Computer chose scissors\n");
        }
        if (choice == computerChoice) {
            System.out.println("It's a tie");
        } else if ((choice == 0 && computerChoice == 2) ||
                (choice == 2 && computerChoice == 1) ||
                (choice == 1 && computerChoice == 0)) {
            System.out.println("You win!");
        } else {
            System.out.println("You lose :(");
        }
    }
}
