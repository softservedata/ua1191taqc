package com.softserve.edu03ide;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;

public class GreencityTest {
    public static final int MAX_IMPLICITLY_WAIT = 10;
    private static WebDriver driver;

    @BeforeAll
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //WebDriverManager.firefoxdriver().setup();
        //driver = new FirefoxDriver();
        //
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(MAX_IMPLICITLY_WAIT));
        driver.manage().window().maximize();
        //
        System.out.println("@BeforeAll executed");
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            //driver.close();
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        List<WebElement> iframe = driver.findElements(By.cssSelector("iframe"));
        System.out.println("\t\t\t\tiframe.size() = " + iframe.size());
        if (iframe.size() > 0) {
            driver.switchTo().frame(iframe.get(0));
            List<WebElement> popupButton = driver.findElements(By.id("close"));
            System.out.println("\t\t\t\tpopupButton.size() = " + popupButton.size());
            if (popupButton.size() > 0) {
                popupButton.get(0).click();
            }
            driver.switchTo().defaultContent();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         Thread.sleep(1000);
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
        // From OS
        String javaHome = System.getenv("JAVA_HOME");
        System.out.println("\t\t\tSystem.getenv(\"JAVA_HOME\") = " + javaHome);
        //
        // From Eclipse/Idea
        String password = System.getenv().get("MY_PASSWORD");
        System.out.println("\t\t\tpassword = " + password);
        //driver.findElement(By.id("password")).sendKeys("Qwerty_1"); // Invalid Solution
        driver.findElement(By.id("password")).sendKeys(password);
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

    @Test
    public void checkMenu() throws InterruptedException {
        driver.findElement(By.cssSelector("app-header:nth-child(1) .nav-left-list:nth-child(4) > .url-name")).click();
        Thread.sleep(1000); // for presentation only
        //
        driver.findElement(By.cssSelector(".nav-left-list:nth-child(6) > .url-name")).click();
        Thread.sleep(1000);
        //
        driver.findElement(By.cssSelector("app-header:nth-child(1) .ubs-header-sing-in-img")).click();
        Thread.sleep(1000);
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
        driver.findElement(By.cssSelector(".ubsStyle")).click();
        Thread.sleep(1000);
        //
        driver.findElement(By.cssSelector("app-header:nth-child(1) .nav-left-list:nth-child(4) > .url-name")).click();
        Thread.sleep(1000);
        //
        driver.findElement(By.cssSelector(".nav-left-list:nth-child(1) > .url-name")).click();
        Thread.sleep(1000);
        //
        driver.findElement(By.linkText("Events")).click();
        Thread.sleep(1000);
        //
        driver.findElement(By.linkText("Places")).click();
        Thread.sleep(1000);
        //
        driver.findElement(By.cssSelector(".nav-left-list:nth-child(4) > .url-name")).click();
        Thread.sleep(1000);
        //
        driver.findElement(By.cssSelector(".nav-left-list:nth-child(5) > .url-name")).click();
        Thread.sleep(1000);
        //
        driver.findElement(By.id("mat-tab-label-0-0")).click();
        Thread.sleep(1000);
        //
        Assertions.assertEquals("My habits", driver.findElement(By.cssSelector("#mat-tab-label-0-0 .mdc-tab__text-label")).getText());
        Thread.sleep(1000);
        //
        driver.findElement(By.cssSelector(".body-2")).click();
        Thread.sleep(1000);
        //
        driver.findElement(By.linkText("Sign out")).click();
        Thread.sleep(1000);
    }

}
