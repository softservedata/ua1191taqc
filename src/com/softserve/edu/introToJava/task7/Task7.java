package com.softserve.edu.introToJava.task7;

import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the initial deposit amount: ");
        double depositAmount = sc.nextDouble();
        System.out.println("Please enter the annual interest rate (in percentage): ");
        double interestRate = sc.nextDouble();
        System.out.println("Please enter the number of years: ");
        int years = sc.nextInt();

        double rate = interestRate / 100;

        double amount = depositAmount;
        for (int t = 1; t <= years; t++) {
            amount = amount * (1 + rate);
            System.out.printf("Amount after %d year(s): %.2f\n", t, amount);
        }
    }
}
