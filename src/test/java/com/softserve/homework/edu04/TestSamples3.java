package com.softserve.homework.edu04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestSamples3 {
    private static final Long IMPLICITLY_WAIT_SECONDS = 10L;
    private static WebDriver driver;

    @BeforeAll
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS));
        driver.manage().window().maximize();
        //       driver.manage().window().setSize(new Dimension(1552, 832));
        System.out.println("@BeforeAll executed");
    }

    @BeforeEach
    public void setupThis() {
        driver.get("https://www.greencity.cx.ua/#/ubs");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/ubs"));
        System.out.println("\t@BeforeEach executed");
    }

    @AfterEach
    public void tearThis() throws InterruptedException {
        // logout, clear cookies, delete token
        Thread.sleep(2000);
        System.out.println("\t@AfterEach executed");
    }

    @Test
    public void verifyTitle() {
        Assertions.assertEquals("GreenCity", driver.getTitle());
    }

    @Test
    public void signInValidUser() throws InterruptedException {
        driver.findElement(By.cssSelector("app-header:nth-child(1) .ubs-header-sign-in")).click();
        assertThat(driver.findElement(By.cssSelector("#mat-mdc-dialog-0 .right-side app-sign-in h1")).getText(), is("Welcome back!"));
        assertThat(driver.findElement(By.cssSelector("h2:nth-child(2)")).getText(), is("Please enter your details to sign in."));
        assertThat(driver.findElement(By.cssSelector("#mat-mdc-dialog-0 .right-side app-sign-in form label:first-of-type")).getText(), is("Email"));
        Thread.sleep(1000);

        WebElement emailInput = driver.findElement(By.id("email"));
        WebElement passwordInput = driver.findElement(By.id("password"));

        emailInput.sendKeys("tyv09754@zslsz.com");
        assertThat(emailInput.getAttribute("value"), is("tyv09754@zslsz.com"));

        passwordInput.sendKeys("Qwerty_1");
        assertThat(passwordInput.getAttribute("value"), is("Qwerty_1"));

        driver.findElement(By.cssSelector(".ubsStyle")).click();
        assertThat(driver.findElement(By.cssSelector("#header_user-wrp > li")).getText(), is("QwertyY"));
    }

    @Test
    public void signInInvalidEmail() {
        driver.findElement(By.cssSelector("app-header:nth-child(1) .ubs-header-sign-in")).click();
        WebElement emailInput = driver.findElement(By.id("email"));
        WebElement passwordInput = driver.findElement(By.id("password"));

        emailInput.sendKeys("invalidemailgreencity.com");
        passwordInput.sendKeys("somepassword");

        driver.findElement(By.cssSelector(".ubsStyle")).click();
        assertThat(driver.findElement(By.cssSelector("#email-err-msg > app-error > div")).getText(), is("Please check if the email is written correctly"));
    }


    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        System.out.println("@AfterAll executed");
    }
}
