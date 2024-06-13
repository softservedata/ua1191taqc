package com.softserve.edu;

import org.junit.jupiter.api.*;

public class AppTest {

    @BeforeAll
    public static void setup() {
        System.out.println("@BeforeAll executed");
    }

    @AfterAll
    public static void tearDown() {
        System.out.println("@AfterAll executed");
    }

    @BeforeEach
    public void setupThis() {
        System.out.println("\t@BeforeEach executed");
    }

    @AfterEach
    public void tearThis() {
        System.out.println("\t@AfterEach executed");
    }

    @Test
    public void testOne() {
        System.out.println("\t\t@Test testOne()");
        Assertions.assertEquals(4, 2 + 2);
    }

    @Test
    public void first() {
        System.out.println("\t\t@Test first() The first test.");
        //
        int actual;
        int expected;
        //
        expected = 5;
        actual = 2 + 3;
        //
        System.out.println("\t\t@Test first() First check:");
        Assertions.assertEquals(expected, actual, "First error founded");
        //
        System.out.println("\t\t@Test first() Second check:");
        Assertions.assertEquals(expected, actual, "Second error founded");
    }
}

