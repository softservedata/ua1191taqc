package com.softserve.hw.pt2;

public class TaskOneSix {
    public static void main(String[] args) {
        System.out.println(removeSpaces("  Hello World   "));
    }
    public static String removeSpaces(String str) {
        return str.replaceAll("\\s", "");
    }
}
