package com.softserve.hw.pt1;

import java.util.Scanner;

public class TemperatureAverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        float [] temperatures = new float[5];

        System.out.println("Enter the temperature for each day in Celsius degrees");

        for (int i = 0; i < temperatures.length; i++) {
            System.out.print("Day " + (i + 1) + ": ");
            temperatures [i] = scanner.nextFloat();
        }
        float sum = 0;
        for (float temperature : temperatures) {
            sum +=temperature;
        }
        float averageTemperature = sum / temperatures.length;

        System.out.println("Average temperature over 5 days: " + averageTemperature + " degrees Celsius");
    }
}
