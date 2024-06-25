package com.softserve.edu.introToJava.task5;

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your grade: ");
        int grade = sc.nextInt();
       if(grade >= 90 && grade <= 100) {
           System.out.println("Your grade is A");
       }
       else if(grade >= 80 && grade <= 89) {
           System.out.println("Your grade is B");
       }
       else if(grade >= 65 && grade <= 79) {
           System.out.println("Your grade is C");
       }
       else if(grade >=  50 && grade <=64) {
           System.out.println("Your grade is D");
       }
       else if(grade <=49) {
           System.out.println("Your grade is F");
       }
    }
}
