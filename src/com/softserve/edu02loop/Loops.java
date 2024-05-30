package com.softserve.edu02loop;

public class Loops {
    public static void main(String[] args) {
        /*
        int number = 0;
        while (number <= 5) {
            System.out.println(number);
            number++;
        }
        System.out.printf("number = " + number);
        */
        /*
        int i = 10;
        do {
            System.out.println(i++);
        } while (i < 5);
        //
        System.out.printf("i = " + i);
        */
        //
        int[] numbers = new int[7];
        numbers[0] = 5;
        numbers[1] = 6;
        numbers[2] = 8;
        numbers[3] = 3;
        numbers[4] = 5;
        numbers[5] = 7;
        numbers[6] = 9;
        //int[] numbers = {5, 6, 8, 3, 5, 7, 9};
        int[] numbers1 = new  int[] {5, 6, 8, 3, 5, 7, 9};
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("i = " + i + "  num = " + numbers[i]);
        }
        //
        for (int current : numbers) {
            System.out.println("value = " + current);
        }
        //
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 5) {
                continue;
            }
            if (numbers[i] == 7) {
                break;
            }
            System.out.println("i = " + i + "  num = " + numbers[i]);
        }
    }
}
