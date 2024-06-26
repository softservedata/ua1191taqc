package com.softserve.edu.oop.task1;

import java.util.Arrays;

public class StringMethods {

    public static boolean task1(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        } else
            return false;
    }

    public static String task2(String s1, int startIndex, int endIndex) {
        return s1.substring(startIndex, endIndex);
    }

    public static int task3(String s1, String s2) {
        return s1.indexOf(s2);
    }

    public static String task4(String s1, String substr, String targetstr) {
        return s1.replaceAll(substr, targetstr);
    }

    public static boolean task5(String s1) {
        for (int i = 0; i < s1.length(); i++) {
            if (Character.isDigit(s1.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static String task6(String s1) {
        return s1.trim();
    }

    public static void main(String[] args) {
        boolean t1 = task1("Hello", "Hello");
        System.out.println(t1);
        System.out.println(task2("Hello World", 2, 10));
        System.out.println(task3("Hello Word", "Word"));
        System.out.println(task4("I like Java", "I", "He"));
        System.out.println(task5("One two 3"));
        System.out.println(task6("    Text Test    "));
    }
}
