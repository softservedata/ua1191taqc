package com.softserve.edu.introToJava.task1;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the price of the product: ");
        double price = sc.nextDouble();
        double vat = price * 1.20;
        System.out.println("Price with VAT: " + vat);
    }
}
