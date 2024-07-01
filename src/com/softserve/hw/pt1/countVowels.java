package com.softserve.hw.pt1;

import java.util.Scanner;

public class countVowels {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String input = scanner.nextLine().toLowerCase();

        int count = 0;

        for (int i = 0; i < input.length(); i ++) {
            char ch = input.charAt(i);

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }
        System.out.println("Total number of vowels in the string: " + count);
        scanner.close();
    }
}
