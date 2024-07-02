package com.softserve.framework.library;

import com.softserve.framework.data.User;
import com.softserve.framework.test.TestRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GuestFunctions {
    public static final Logger logger = LoggerFactory.getLogger(GuestFunctions.class);
    private WebDriver driver;

    public GuestFunctions(WebDriver driver) {
        this.driver = driver;
    }

    //public void signIn(String email, String password) {
    public void signIn(User user) {
        logger.debug("Start signIn with user = " + user);
        //
        // Click Login Button
        //driver.findElement(By.cssSelector("a.ubs-header-sign-in")).click();
        //driver.findElement(By.cssSelector(".ubs-header-sing-in-img")).click();
        //driver.findElement(By.cssSelector("app-header:nth-child(1) .ubs-header-sing-in-img")).click();
        driver.findElement(By.cssSelector("app-ubs .ubs-header-sing-in-img")).click();
        //
        // Burger menu click
        //driver.findElement(By.cssSelector("div.menu-icon-wrapper")).click();
        //driver.findElement(By.cssSelector("a.tertiary-global-button")).click();
        TestRunner.presentationSleep(); // For Presentation ONLY
        //
        logger.trace("Point 33");
        //
        // Fill email input
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(user.getEmail());
        TestRunner.presentationSleep(); // For Presentation ONLY
        //
        // Fill password input
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(user.getPassword());
        TestRunner.presentationSleep(); // For Presentation ONLY
        //
        // Press Button Login
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        TestRunner.presentationSleep(); // For Presentation ONLY
        //
        logger.debug("Done signIn with user = " + user);
    }

}
