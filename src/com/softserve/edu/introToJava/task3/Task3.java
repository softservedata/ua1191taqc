package com.softserve.edu.introToJava.task3;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text: ");
        String text = sc.nextLine();

        String vowels = "aeiouAEIOU";
        int vowelCount = 0;
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if (vowels.contains(String.valueOf(currentChar))) {
                vowelCount++;
            }
        }
        System.out.println("Vowels: " + vowelCount);
    }
}
