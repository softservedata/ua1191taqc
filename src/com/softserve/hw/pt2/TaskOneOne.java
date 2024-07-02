package com.softserve.hw.pt2;

public class TaskOneOne {
    public static void main(String[] args) {
        System.out.println(equals("Hello", "hello"));
        System.out.println(equals("Hello", "hello", true));
    }
    public static boolean equals(String s1, String s2) {
        return s1.equals(s2);
    }
    public static boolean equals(String s1, String s2, boolean ignoreCase) {
        if (ignoreCase) {
            return s1.equalsIgnoreCase(s2);
        } else {
            return s1.equals(s2);
        }
    }
}
