package com.softserve.edu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SelSimpleTest {

    //@BeforeAll
    public static void setup() {
        System.out.println("@BeforeAll executed");
    }

    //@AfterAll
    public static void tearDown() {
        System.out.println("@AfterAll executed");
    }

    //@BeforeEach
    public void setupThis() {
        System.out.println("\t@BeforeEach executed");
    }

    //@AfterEach
    public void tearThis() {
        System.out.println("\t@AfterEach executed");
    }

    public void testSelen() throws InterruptedException {
        System.out.println("\t\t@Test testSelen()");
        //
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Cheese!");
        element.submit();
        //
        Thread.sleep(2000);
        driver.quit();
        //
        Assertions.assertEquals(4, 2 + 2);
    }
}
