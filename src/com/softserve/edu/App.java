package com.softserve.edu;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class App {

    private static final long IMPLICITLY_WAIT_SECONDS = 10L;
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello world!");
        //
        System.setProperty("webdriver.chrome.driver", "lib/chromedriver");
        //
        WebDriver driver = new ChromeDriver();
        //
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS)); // by default its 0
        driver.manage().window().maximize();
        //
        driver.get("https://google.com/");
        Thread.sleep(2000);
        //
        driver.findElement(By.name("q")).sendKeys("mac");
        Thread.sleep(2000);
        //
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        Thread.sleep(8000);
        //
        driver.quit();
    }

}