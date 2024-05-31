package edu8IntroductionToJava.task7;

import java.util.Scanner;

public class InterestCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the initial deposit amount: ");
        double principal = scanner.nextDouble();
        System.out.print("Enter the annual interest rate (in %): ");
        double annualRate = scanner.nextDouble() / 100;
        System.out.print("Enter the number of years: ");
        int years = scanner.nextInt();
        double amount = principal * Math.pow(1 + annualRate, years);
        System.out.println("The final amount after " + years + " years is: " + amount);
    }
}
