package com.softserve.homework.edu08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class TestRunner {
    protected static WebDriver driver;
    private static final Long IMPLICITLY_WAIT_SECONDS = 10L;
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @BeforeAll
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS));
        driver.manage().window().maximize();
        System.out.println("@BeforeAll executed");
    }

    @BeforeEach
    public void setupThis() {
        driver.get("https://www.greencity.cx.ua/#/ubs");
        System.out.println("\t@BeforeEach executed");
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        System.out.println("@AfterAll executed");
    }

    @AfterEach
    public void tearThis(TestInfo testInfo) {
        if (testInfo.getTags().contains("Failed")) {
            logger.error("Test_Name = " + testInfo.getDisplayName() + " failed");
            System.out.println("\t\t\tTest_Name = " + testInfo.getDisplayName() + " fail");
            System.out.println("\t\t\tTest_Method = " + testInfo.getTestMethod() + " fail");
        }

        // Logout and delete cookies
        driver.manage().deleteAllCookies();

        // Refresh page
        driver.navigate().refresh();
        System.out.println("\t@AfterEach executed");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.localStorage.removeItem('accessToken');");
        js.executeScript("window.localStorage.removeItem('refreshToken');");
    }

}
