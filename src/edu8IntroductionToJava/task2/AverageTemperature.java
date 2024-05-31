package edu8IntroductionToJava.task2;

import java.util.Scanner;

public class AverageTemperature {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float sum = 0.0f;
        for (int i = 1; i <= 5; i++) {
            System.out.print("Enter temperature for day " + i + ": ");
            float temp = scanner.nextFloat();
            sum += temp;
        }
        float average = sum / 5;
        System.out.println("Average temperature over 5 days: " + average);
    }
}
