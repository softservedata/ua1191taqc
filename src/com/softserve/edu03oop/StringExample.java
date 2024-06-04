package com.softserve.edu03oop;

public class StringExample {
    private static String str = "Hello Java!";

    static {
        System.out.println("static block, str = " + str);
    }

    public static void main(String[] args) {
        System.out.println("Hello from the method 'main'");
    }
}
