package com.softserve.hw.pt2;

public class TaskOneFive {
    public static void main(String[] args) {
        System.out.println(containsDigits("Hello123"));
        System.out.println(containsDigits("Hello"));
    }
    public static boolean containsDigits(String str) {
        for (char a : str.toCharArray()) {
            if (Character.isDigit(a)) {
                return true;
            }
        }
        return false;
    }
}
