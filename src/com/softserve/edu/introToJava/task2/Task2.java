package com.softserve.edu.introToJava.task2;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter temperature for 5 days: ");
        float temperature = 0.0f;
        float sum = 0.0f;
        for(int i = 0; i < 5; i++){
            temperature = sc.nextFloat();
            sum += temperature;
        }
        float average = sum / 5;
        System.out.println("Average temperature: " + average);
    }
}
