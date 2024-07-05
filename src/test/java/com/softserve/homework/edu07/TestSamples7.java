package com.softserve.homework.edu07;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class TestSamples7 extends TestRunner {
    private SignInPage signInPage;

    @BeforeEach
    public void setupThis() {
        super.setupThis();
        signInPage = new SignInPage(driver);
    }

    @AfterEach
    public void tearDownEach() {
        // Restart the browser to ensure a clean state
        driver.quit();
        setup();
    }

    @Test
    public void verifyTitle() {
        Assertions.assertEquals("GreenCity", driver.getTitle());
    }

    @ParameterizedTest
    @MethodSource("com.softserve.homework.edu07.SignInDataRepository#validSignInData")
    public void signInValidUser(SignInData data) {
        signInPage.clickSignInButton();
        signInPage.verifySignInModal();
        signInPage.enterCredentials(data.getEmail(), data.getPassword());
        signInPage.submitSignIn();
        signInPage.verifyUserSignedIn(data.getExpectedUsername());
    }

    @ParameterizedTest
    @MethodSource("com.softserve.homework.edu07.SignInDataRepository#invalidSignInData")
    public void signInInvalidEmail(SignInData data) {
        signInPage.clickSignInButton();
        signInPage.verifySignInModal();
        signInPage.enterCredentials(data.getEmail(), data.getPassword());
        signInPage.submitSignIn();
        signInPage.verifyErrorMessage(data.getExpectedErrorMessage());
    }
}
