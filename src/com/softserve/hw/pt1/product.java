package com.softserve.hw.pt1;

import java.util.Scanner;

public class product {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the price for product excluding VAT");

        double initiatePrice = scanner.nextDouble();
        double vatRate = 0.20;
        double vatAmount = initiatePrice * vatRate;
        double finalPrice = initiatePrice + vatAmount;

        System.out.println("Initial price (excluding VAT): $" + initiatePrice);
        System.out.println("VAT amount: $" + vatAmount);
        System.out.println("Final price (including VAT): $" + finalPrice);
    }
}





