package com.softserve.edu.oop.task3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Arr {
    private ArrayList<Integer> arrayList;

    public Arr() {
        arrayList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            int randomNumber = random.nextInt(100) + 1;
            arrayList.add(randomNumber);
        }
    }

    public ArrayList<Integer> getArrayList() {
        return arrayList;
    }

    // Task 1: Print the ArrayList
    public void printArrayList() {
        System.out.println(arrayList);
    }

    // Task 2: Find and print the maximum and minimum number
    public int findMaxNumber() {
        return Collections.max(arrayList);
    }

    public int findMinNumber() {
        return Collections.min(arrayList);
    }

    // Task 3: Calculate and print the average value
    public double calculateAverage() {
        double sum = 0;
        for (int number : arrayList) {
            sum += number;
        }
        return sum / arrayList.size();
    }

    // Task 4: Remove all even numbers
    public void removeEvenNumbers() {
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            if (arrayList.get(i) % 2 == 0) {
                arrayList.remove(i);
            }
        }
    }

    // Task 5: Check if the collection contains a given number
    public boolean containsNumber(int number) {
        return arrayList.contains(number);
    }

    // Task 6: Sort the collection in ascending order
    public void sortArrayList() {
        Collections.sort(arrayList);
    }

    public static void main(String[] args) {
        Arr arr = new Arr();

        // Task 1
        arr.printArrayList();

        // Task 2
        int maxNumber = arr.findMaxNumber();
        int minNumber = arr.findMinNumber();
        System.out.println("Max number: " + maxNumber);
        System.out.println("Min number: " + minNumber);

        // Task 3
        double averageNum = arr.calculateAverage();
        System.out.println("Average: " + averageNum);

        // Task 4
        arr.removeEvenNumbers();
        System.out.println("Without even: " + arr.getArrayList());

        // Task 5
        int checkNumber = 50; // Example number to check
        if (arr.containsNumber(checkNumber)) {
            System.out.println("Number " + checkNumber + " is in Array");
        } else {
            System.out.println("Number " + checkNumber + " is not in Array");
        }

        // Task 6
        arr.sortArrayList();
        System.out.println("Sorted Array: " + arr.getArrayList());
    }
}
