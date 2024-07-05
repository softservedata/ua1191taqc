package com.softserve.homework.edu07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestRunner {
    protected static WebDriver driver;
    private static final Long IMPLICITLY_WAIT_SECONDS = 10L;

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
}
