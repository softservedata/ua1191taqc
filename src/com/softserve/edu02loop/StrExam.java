package com.softserve.edu02loop;

public class StrExam {

    public static void main(String[] args) {
        /*
        String a0 = "Java"; // equals new String("Java");
        String a1 = "Java"; // set reference
        String a2 = new String("Java"); // create new object
        //
        System.out.println("(a0 == a1) =  " + (a0 == a1)); // true
        System.out.println("(a0 == a2) =  " + (a0 == a2)); // false
        //
        System.out.println("a0.equals(a1) =  " + a0.equals(a1)); // true
        System.out.println("a0.equals(a2) =  " + a0.equals(a2)); // true
        //
        System.out.println("a0.compareTo(a1) =  " + a0.compareTo(a1)); // 0
        System.out.println("a0.compareTo(a2) =  " + a0.compareTo(a2)); // 0
        //
        System.out.println("a0.hashCode() =  " + a0.hashCode());
        System.out.println("a1.hashCode() =  " + a1.hashCode());
        System.out.println("a2.hashCode() =  " + a2.hashCode());
        //
        String s = "abracadabra abba";
        //s = s.replace("a", "-");
        //s = s.replace("ab", "-");
        s = s.substring(0, 12);
        System.out.println("s = " + s);
        */
        // Reverse
        String str = "My friend is Mercedes.";
        String rev = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            rev = rev + str.charAt(i);
        }
        System.out.println("str = " + str);
        System.out.println("rev = " + rev);
        //
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        System.out.printf(" sb = " + sb.toString());
    }
}
