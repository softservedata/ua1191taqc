package com.softserve.edu07wait;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TabTest {

    private static final Long ONE_SECOND_DELAY = 1000L;
    private static WebDriver driver;

    protected static void presentationSleep() {
        presentationSleep(1);
    }

    // Overload
    protected static void presentationSleep(int seconds) {
        try {
            Thread.sleep(seconds * ONE_SECOND_DELAY); // For Presentation ONLY
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @BeforeAll
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // 0 by default
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(100)); // 0 by default
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(180)); // 300 by default
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void tear() {
        presentationSleep(4); // For Presentation ONLY
        if (driver != null) {
            driver.quit();
        }
    }

    @BeforeEach
    public void setupThis() {
        driver.get("https://selenium.dev/downloads/");
        presentationSleep(2); // For Presentation ONLY
    }

    @AfterEach
    public void tearThis(TestInfo testInfo) {
        presentationSleep(); // For Presentation ONLY
    }

    @Test
    public void checkNewTab() {
        String originalWindow = driver.getWindowHandle();
        // Create new tab
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.google.com/");
        presentationSleep(); // For Presentation ONLY
        //
        System.out.println("Number of tabs = " + driver.getWindowHandles().size());
        driver.findElement(By.name("q")).sendKeys("mac" + Keys.ENTER);
        presentationSleep(2); // For Presentation ONLY
        //
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
            presentationSleep(2); // For Presentation ONLY
            System.out.println("Title = " + driver.getTitle());
        }
        //
        for (String windowHandle : driver.getWindowHandles()) {
            if (originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                System.out.println("Return to Original tab");
                break;
            }
        }
        presentationSleep(); // For Presentation ONLY
    }

}
