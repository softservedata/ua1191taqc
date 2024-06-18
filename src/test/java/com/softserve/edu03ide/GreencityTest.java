package com.softserve.edu03ide;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class GreencityTest {
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
        driver.get("https://www.greencity.cx.ua/#/ubs");
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
    public void testLogin() throws InterruptedException {
        System.out.println("\t\t@Test testSelen()");
        //
        //driver.findElement(By.cssSelector(".ubsHomepage")).click();
        //Thread.sleep(1000);
        //
        //driver.findElement(By.cssSelector("app-header:nth-child(1) .ubs-header-sing-in-img")).click();
        driver.findElement(By.cssSelector("div.main-content.app-container img.ubs-header-sing-in-img.ng-star-inserted")).click();
        Thread.sleep(1000);
        //
        //driver.findElement(By.cssSelector(".main-picture")).click();
        //Thread.sleep(1000);
        //
        driver.findElement(By.id("email")).click();
        Thread.sleep(1000);
        //
        driver.findElement(By.id("email")).sendKeys("tyv09754@zslsz.com");
        Thread.sleep(1000);
        //
        driver.findElement(By.id("password")).click();
        Thread.sleep(1000);
        //
        driver.findElement(By.id("password")).sendKeys("Qwerty_1");
        Thread.sleep(1000);
        //
        driver.findElement(By.cssSelector("button.ubsStyle")).click();
        Thread.sleep(1000);
        //
        //Assertions.assertEquals("QwertyY",
        //        driver.findElement(By.cssSelector("app-header:nth-child(1) .body-2")).getText() );
        Assertions.assertEquals("QwertyY",
                driver.findElement(By.cssSelector("div.main-content.app-container ul#header_user-wrp > li.ubs-user-name")).getText() );
        Thread.sleep(1000);
        //
        //driver.findElement(By.cssSelector("app-header:nth-child(1) .body-2")).click();
        driver.findElement(By.cssSelector("div.main-content.app-container ul#header_user-wrp > li.ubs-user-name")).click();
        Thread.sleep(1000);
        //
        //driver.findElement(By.linkText("Sign out")).click();
        driver.findElement(By.cssSelector("div.main-content.app-container li[aria-label='sign-out'] > a")).click();
        Thread.sleep(1000);
        //
        WebElement signup = driver.findElement(By.cssSelector("div.main-content.app-container div.ubs-header_sign-up-btn span"));
        //
        Assertions.assertTrue(signup.getText().contains("Sign up"));
    }
}
