package com.softserve.edu02loop;

import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        /*
        // Sum
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum = sum + i;
        }
        System.out.printf("sum = " + sum);
        */
        // /*
        Scanner sc = new Scanner(System.in);
        System.out.print("Input number = ");
        int n = sc.nextInt();
        boolean isPrime = true;
        for (int i = 2; i < (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                System.out.println("i = " + i);
                isPrime = false;
                break;
            }
        }
        System.out.println("isPrime = " + isPrime);
        sc.close();
        // */
    }
}
