package com.softserve.framework.test;

import com.softserve.framework.data.User;
import com.softserve.framework.data.UserRepository;
import com.softserve.framework.library.GuestFunctions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.stream.Stream;

public class GreenCityLoginTest extends TestRunner {

    private static Stream<Arguments> provideUsers() {
//        return Stream.of(
//                Arguments.of("tyv09754@zslsz.com", "Qwerty_1", "QwertyY")
//        );
//        return Stream.of(
//                Arguments.of(new User("tyv09754@zslsz.com", "Qwerty_1", "QwertyY"))
//        );
        return Stream.of(
                Arguments.of(UserRepository.getValidUserQwertyY())//,
//                Arguments.of(UserRepository.getValidUserMyName())
        );
//        return UserRepository.fromList().stream()
//                .map(user->Arguments.of(user));
//        return UserRepository.fromCsv().stream()
//                .map(user->Arguments.of(user));
    }

    //@ParameterizedTest(name = "{index} => email={0}, password={1}, username={2}")
    @ParameterizedTest(name = "{index} => user={0}")
    @MethodSource("provideUsers")
    //@Test
    //public void checkLogin(String email, String password, String username) {
    public void checkLogin(User user) {
        logger.info("Start checkLogin() with user = " + user);
        //
        guestFunctions.signIn(user);
        //
        // get Username
        String actualUserName = driver.findElement(By.cssSelector("li.ubs-user-name")).getText();
        String expectedUserName = user.getUsername();
        presentationSleep(); // For Presentation ONLY
        //
        // Check
        Assertions.assertEquals(expectedUserName, actualUserName);
        presentationSleep(); // For Presentation ONLY
        //
        System.out.println("\t\tTest testUi() executed");
    }

    //@ParameterizedTest(name = "{index} => user={0}")
    //@MethodSource("provideUsers")
    //@Test
    public void checkMyHabit(User user) {
        logger.info("Start checkMyHabit() with user = " + user);
        //
        guestFunctions.signIn(user);
        //
        // get Username
        String actualUserName = driver.findElement(By.cssSelector("li.ubs-user-name")).getText();
        String expectedUserName = user.getUsername();
        presentationSleep(); // For Presentation ONLY
        //
        // Green City menu Click
        //driver.findElement(By.xpath("//ul[@role='tablist']//a[contains(text(),'Green City')]")).click();
        driver.findElement(By.cssSelector("app-header:nth-child(1) ul[role='tablist'] a[href*='greenCity']")).click();
        presentationSleep(); // For Presentation ONLY
        //
        // Start forming a habit button click
        driver.findElement(By.cssSelector("div#main-content button.primary-global-button.btn")).click();
        presentationSleep(); // For Presentation ONLY
        //
        String actualLabel = driver.findElement(By.cssSelector("div[aria-selected='true'] div.mat-tab-label-content")).getText();
        String expectedLabel = "My habits";
        presentationSleep(); // For Presentation ONLY
        //
        // Check
        Assertions.assertTrue(actualLabel.contains(expectedLabel));
        presentationSleep(); // For Presentation ONLY
        //
        System.out.println("\t\tTest testUi() executed");
    }
}
