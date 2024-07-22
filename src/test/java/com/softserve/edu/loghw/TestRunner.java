package com.softserve.edu.loghw;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.BasicConfigurator;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class TestRunner {
    protected static WebDriver driver;
    protected static boolean isTestSuccessful = false;
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @BeforeAll
    public static void setUp() {
        BasicConfigurator.configure();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.greencity.cx.ua/#/ubs");
        driver.manage().window().setSize(new Dimension(1264, 798));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeEach
    public void initPageElements() {
        PageFactory.initElements(driver, this);
    }

    @BeforeEach
    public void setupThis() {
        driver.get("https://www.greencity.cx.ua/#/ubs");
    }
    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

    @AfterEach
    public void tearThis(TestInfo testInfo) {
        if (!isTestSuccessful) {
            // Log.error
            logger.error("Test_Name = " + testInfo.getDisplayName() + " failed");
            //
            System.out.println("\t\t\tTest_Name = " + testInfo.getDisplayName() + " fail");
            System.out.println("\t\t\tTest_Method = " + testInfo.getTestMethod() + " fail");
            //
        }
        //
        // delete All Cookies;
        driver.manage().deleteAllCookies();
        // Refresh page
        driver.navigate().refresh();
        //
        System.out.println("\t@AfterEach executed");
    }
}
