package com.softserve.edu.oop.task3;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class Arr {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            int randomNumber = random.nextInt(100) + 1;
            arrayList.add(randomNumber);
        }
        //Task 1
        System.out.println(arrayList);

        //Task 2
        int maxNumber = Collections.max(arrayList);
        int minNumber = Collections.min(arrayList);

        System.out.println("Max number: " + maxNumber);
        System.out.println("Min number: " + minNumber);

        //Task 3
        double averageNum;
        double sum = 0;

        for (int i = 0; i < arrayList.size(); i++) {
            sum += i;
        }
        averageNum = sum / arrayList.size();

        System.out.println("Average: " + averageNum);

        //Task4
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            if (arrayList.get(i) % 2 == 0) {
                arrayList.remove(i);
            }
        }

        System.out.println("Without even: " + arrayList);

        //Task5
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number (0-100): ");
        int checkNumber = scanner.nextInt();
        if (arrayList.contains(checkNumber))
            System.out.println("Number " + checkNumber + " is in Array");
        else
            System.out.println("Number " + checkNumber + " is not in Array");


        //Task 6
        Collections.sort(arrayList);
        System.out.println("Sorted Array: " + arrayList);
    }

}
