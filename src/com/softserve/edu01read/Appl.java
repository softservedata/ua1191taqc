package com.softserve.edu01read;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * <b>Super class</b>
 */
public class Appl {

    /**
     *
     * @param args Arguments form copmmand line.
     */
    public static void main(String[] args) {
        /*
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = 0;
        System.out.print("Input number: ");
        try {
            x = Integer.parseInt(br.readLine());
        } catch (NumberFormatException | IOException e) {
            System.out.println("I/O Error.");
        }
        System.out.println("Number is " + (x + 1));
		//
		try {
			br.close();
		} catch (IOException e) {
			System.out.println("close() Error.");
		}
        */
        // /*
        int x = 0;
        String s = "0";
        System.out.print("\\ Input number: ");
        try (Scanner sc = new Scanner(System.in)) {
            //x = sc.nextInt();
            //
            //s = sc.nextLine();
            //x = Integer.parseInt(s);
            //
            x = sc.nextInt();
            System.out.print("Input second line: ");
            s = sc.nextLine();
            s = sc.nextLine();
        } catch (NumberFormatException | InputMismatchException e) {
            System.out.println("I/O Error.");
        }
        System.out.println("Number is " + (x + 1));
        System.out.println("Line is " + s);
        // */
	}

}
