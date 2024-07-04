package com.softserve.edu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class ArrTest {
    private Arr arr;

    @BeforeEach
    void setUp() {
        arr = new Arr();
    }

    @Test
    @DisplayName("Array generation")
    @Order(1)
    void testArrayListGeneration() {
        assertEquals(20, arr.getArrayList().size());
    }

    @Test
    @DisplayName("Max and min number")
    void testMaxAndMinNumber() {
        int maxNumber = arr.findMaxNumber();
        int minNumber = arr.findMinNumber();

        assertEquals(arr.findMaxNumber(), maxNumber);
        assertEquals(arr.findMinNumber(), minNumber);
    }

    @Test
    @DisplayName("Average number")
    void testAverageNumber() {
        double sum = 0;
        for (int i = 0; i < arr.getArrayList().size(); i++) {
            sum += arr.getArrayList().get(i);
        }

        double expectedAverage = sum / arr.getArrayList().size();
        double actualAverage = arr.calculateAverage();

        assertEquals(expectedAverage, actualAverage);
    }

    @Test
    @DisplayName("Remove all even numbers")
    void testRemoveEvenNumbers() {
        arr.removeEvenNumbers();
        ArrayList<Integer> arrayList = arr.getArrayList();

        boolean containsEven = false;
        for (int number : arrayList) {
            if (number % 2 == 0) {
                containsEven = true;
                break;
            }
        }

        assertFalse(containsEven);
    }

    @Test
    @DisplayName("Find given number in array")
    void testFindGivenNumberInArray() {
        int checkNumber = 50;
        boolean containsNumber = arr.containsNumber(checkNumber);
        assertTrue(containsNumber);
    }

    @Test
    @DisplayName("Array sorted correctly")
    void testSorting() {
        arr.sortArrayList();
        ArrayList<Integer> sortedList = new ArrayList<>(arr.getArrayList());
        Collections.sort(sortedList);

        assertEquals(sortedList, arr.getArrayList());
    }
}