package com.softserve.hw.pt2;

public class TaskOneTwo {
    public static void main(String[] args) {
        System.out.println(getSubstring("Hello World", 0, 5));
        System.out.println(getSubstring("Hello World", 6, 11));
    }
    public static String getSubstring(String str, int start, int end) {
        if (start < 0 || end > str.length() || start > end) {
            return "";
        }
        return str.substring(start, end);
    }
}
