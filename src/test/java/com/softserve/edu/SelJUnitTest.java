package com.softserve.edu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SelJUnitTest {

    private static WebDriver driver;

    @BeforeAll
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        //
        System.out.println("@BeforeAll executed");
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        //
        System.out.println("@AfterAll executed");
    }

    @BeforeEach
    public void setupThis() {
        driver.get("http://www.google.com");
        //
        System.out.println("\t@BeforeEach executed");
    }

    @AfterEach
    public void tearThis() throws InterruptedException {
        // logout, clear cookies, delete token
        Thread.sleep(2000);
        //
        System.out.println("\t@AfterEach executed");
    }

    @Test
    public void testSelen() {
        System.out.println("\t\t@Test testSelen()");
        //
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Cheese!");
        element.submit();
        //
        Assertions.assertEquals(4, 2 + 2);
    }
}