package com.softserve.edu09map;

import java.util.*;

public class ProgCollections {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("second", "third", "fourth", "first", "first");
        System.out.println("Origin List = " + list);
        Collections.reverse(list);
        System.out.println("reverse List = " + list);

        // sorting
        Collections.sort(list);
        System.out.println("Sorted List = " + list);

        //reverse sort order
        //Collections.sort(list, Collections.reverseOrder());
        System.out.println("Sorted List by reverseOrder = " + list);

        // uses a binary search algorithm to find a specific element;
        // returns the element number or a negative number
        System.out.println(Collections.binarySearch(list, "second"));

        //randomly reorders elements
        Collections.shuffle(list);
        System.out.println("After shuffling: " + list);

        // max value, min value,
        System.out.println(Collections.max(list));
        System.out.println(Collections.min(list));

        //cyclically shifts the elements passed to it by distance
        // positions forward (+) or backward (-)
        Collections.rotate(list, -1);
        System.out.println("rotate List = " + list);

        // copy collection
        //List<String> listDestination = Arrays.asList("green", "black");
        List<String> listDestination = new ArrayList<>();
        Collections.copy(list, listDestination);
        System.out.println("Copy List = " + list);

        //eturns the total number of occurrences of the
        // specified element in the list
        System.out.println(Collections.frequency(list, "first"));
    }
}
