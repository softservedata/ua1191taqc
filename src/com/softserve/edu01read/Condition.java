package com.softserve.edu01read;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Condition {
    public static void main(String[] args) throws IOException {
        /*
        int temperature = 15;
        if (temperature < 10) {
            System.out.println("if: It is too cold");
        } else if (temperature > 30) {
            System.out.println("if: It is Hot");
        } else {
            System.out.println("if: It is Ok");
        }
        //
        String s = temperature < 10 ? "if: It is too cold" : temperature > 30 ? "if: It is Hot" : "if: It is Ok";
        System.out.println("RESULT: " + s);
        */
        /*-
        boolean isLeap;
        int year = 1900;
        //int year = 2000;
        if (year % 4 != 0) {
            isLeap = false;
        } else if (year % 100 != 0) {
            isLeap = true;
        } else if (year % 400 == 0) {
            isLeap = true;
        } else {
            isLeap = false;
        }
        System.out.println("isLeap = " + isLeap);
        */
        // /*-
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Do you enjoy Java? (yes/no/maybe): ");
        String input = br.readLine();
        //
        switch (input.toLowerCase()) {
            case "yes":
                System.out.println("Ok!");
            case "maybe":
                System.out.println("Great!");
                break;
            case "no":
                System.out.println("Too bad!");
                break;
            default:
                System.out.println("Wrong!");
        }
        //
        String s = input.toLowerCase();
        if (s.equals("yes")) {
            System.out.println("Ok! 2");
        }
        if (s.equals("yes") || s.equals("maybe")) {
            System.out.println("Great! 2");
        } else if (s.equals("no")) {
            System.out.println("Too bad! 2");
        } else {
            System.out.println("Wrong! 2");
        }
        //
        // /*
        // Starting from Java 14 we can use switch expression
        var result = switch (input.toLowerCase()) {
            case "yes", "maybe" -> "Great!_3";
            case "no" -> "Too bad!_3";
            default -> "Wrong!_3";
        };
        System.out.println("result = " + result);
        // */
    }
}
