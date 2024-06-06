package com.softserve.edu05ar;

import java.util.Arrays;

public class AppArr {
    public static void main(String[] args) {
        /*
        int[] month = new int[12];
        month[0] = 31;
        month[1] = 28;
        month[2] = 31;
        month[3] = 30;
        month[4] = 31;
        month[5] = 30;
        month[6] = 31;
        month[7] = 31;
        month[8] = 30;
        month[9] = 31;
        month[10] = 30;
        month[11] = 31;
//        for (int i = 0; i < month.length; i++) {
//            System.out.println("month[" + i + "] = " + month[i]);
//        }
        //System.out.println("month = " + month);
        System.out.println("month = " + Arrays.toString(month) );
        */
        /*
        int[][] twoD = new int[4][];
        twoD[0] = new int[1];
        twoD[1] = new int[3];
        twoD[2] = new int[1];
        twoD[3] = new int[2];
        twoD[0][0] = 1;
        twoD[1][0] = 2;
        twoD[1][1] = 3;
        twoD[1][2] = 4;
        twoD[2][0] = 5;
        twoD[3][0] = 6;
        twoD[3][1] = 7;
        for (int i = 0; i < twoD.length; i++) {
            for (int j = 0; j < twoD[i].length; j++) {
                System.out.print("  " + twoD[i][j]);
            }
            System.out.println();
        }
        */
        int[] arr = {3, 7, 1, 9, 2, 5};
        System.out.println("Original arr = " + Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("Sorted arr = " + Arrays.toString(arr));
        int pos = Arrays.binarySearch(arr, 5);
        System.out.printf("pos = " + pos);
    }
}
