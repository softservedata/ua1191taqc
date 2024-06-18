package com.softserve.edu02ju;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class JUnitOrderTest {

    @Test
    @Order(2)
    public void testOne() {
        System.out.println("\t\t@Test testOne()");
        assertEquals(6, 2 + 4);
    }

    @Test
    @Order(1)
    public void testTwo() {
        System.out.println("\t\t@Test testTwo()");
        assertEquals(6 + 1, 2 + 4 + 1);
    }

    @Test
    @Order(3)
    public void testThree() {
        System.out.println("\t\t@Test testThree()");
        assertEquals(6 - 1, 2 - 1 + 4);
    }

}
