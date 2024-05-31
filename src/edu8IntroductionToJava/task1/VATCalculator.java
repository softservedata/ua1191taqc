package edu8IntroductionToJava.task1;

import java.util.Scanner;

public class VATCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the price of the product excluding VAT: ");
        double priceExclVAT = scanner.nextDouble();
        double priceInclVAT = priceExclVAT * 1.20;
        System.out.println("Price excluding VAT: " + priceExclVAT);
        System.out.println("Price including VAT: " + priceInclVAT);
    }
}

