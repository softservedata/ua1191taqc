
package com.softserve.edu02ju;

import org.bouncycastle.util.Arrays;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SimpleJUnit5Test {

    @BeforeAll
    public static void setup() {
        System.out.println("@BeforeAll executed, time = " + System.currentTimeMillis());
    }

    @AfterAll
    public static void tear() {
        System.out.println("@AfterAll executed");
    }

    @BeforeEach
    public void setupThis() {
        System.out.println("\t@BeforeEach executed, time = " + System.currentTimeMillis());
    }

    @AfterEach
    public void tearThis() {
        System.out.println("\t@AfterEach executed");
    }

    @Test
    @Order(4)
    public void testOne() {
        System.out.println("\t\t@Test testOne()");
        Assertions.assertEquals(4, 2 + 2);
    }

    @Test
    @Order(3)
    public void testTwo() {
        System.out.println("\t\t@Test testTwo()");
        //int i = 0;
        //i = 10 / (i + 0);
        //Assertions.assertEquals(6 + 1, 2 + 4);
        Assertions.assertNotEquals(6 + 1, 2 + 4);
        Assertions.assertFalse(6 + 1 == 2 + 4);
    }

    @Test
    @Order(2)
    void testExpectedException() {
        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
            //Code under test
            int i = 0;
            i = 10 / (i + 0);
        });
        System.out.println("\t\tMessage = " + thrown.getMessage());
        Assertions.assertEquals("/ by zero", thrown.getMessage());
    }

    @Test
    @Order(1)
    void testExpectedException2() {
        NumberFormatException thrown = Assertions.assertThrows(NumberFormatException.class, () -> {
            int k = Integer.parseInt("One");
        }, "NumberFormatException was expected");
        System.out.println("\t\tMessage = " + thrown.getMessage());
        Assertions.assertEquals("For input string: \"One\"", thrown.getMessage());
    }

    @DisplayName("Should pass a non-null message to our test method")
    @ParameterizedTest
    @ValueSource(strings = {"Hello", "World"})
    void shouldPassNonNullMessageAsMethodParameter(String message) {
        System.out.println("\t\tMessage = " + message);
        Assertions.assertNotNull(message);
    }

    @DisplayName("Should calculate the correct sum")
    @ParameterizedTest(name = "{index} => a={0}, b={1}, sum={2}")
    @CsvSource({
            "1, 1, 2",
            "2, 3, 5"
    })
    void sum(int a, int b, int sum) {
        System.out.println("\t\ta = " + a + "  b = " + b);
        Assertions.assertEquals(sum, a + b);
    }

    public static Object[][] numbersPositive() {
        return new Object[][]{
                {new int[]{1, 2, 3, 4, 5}, 3},
                {new int[]{5, 4, 3, 2, 1}, 4},
                {new int[]{1, 2, 3, 4, 10}, 10}
        };
    }

    @ParameterizedTest
    @MethodSource("numbersPositive")
    public void testFive(int[] arr, int num) {
        System.out.println("\t\t@Test testThree(), ThreadId = " + Thread.currentThread().getId() + "  num = " + num);
        Assertions.assertTrue(Arrays.contains(arr, num), "Array should contain the number");
    }

    public static Object[][] numbersNegative() {
        return new Object[][]{
                {new int[]{1, 2, 3, 4, 5}, 8},
                {new int[]{5, 4, 3, 2, 1}, 9},
                {new int[]{1, 2, 3, 4, 10}, 17}
        };
    }

    @ParameterizedTest
    @MethodSource("numbersNegative")
    public void testSix(int[] arr, int num) {
        System.out.println("\t\t@Test testThree(), ThreadId = " + Thread.currentThread().getId() + "  num = " + num);
        Assertions.assertFalse(Arrays.contains(arr, num), "Array should contain the number");
    }
}
