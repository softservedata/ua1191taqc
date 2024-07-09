package com.softserve.homework.edu08;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestSamples8 extends TestRunner {
    private SignInPage signInPage;
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @BeforeEach
    public void setupThis() {
        super.setupThis();
        signInPage = new SignInPage(driver);
    }

    @Test
    public void verifyTitle() {
        logger.debug("Start verifyTitle()");
        Assertions.assertEquals("GreenCity", driver.getTitle());
    }

    @ParameterizedTest
    @MethodSource("com.softserve.homework.edu08.SignInDataRepository#validSignInData")
    public void signInValidUser(SignInData data) {
        logger.debug("Start signInValidUser()");
        signInPage.clickSignInButton();
        signInPage.verifySignInModal();
        signInPage.enterCredentials(data.getEmail(), data.getPassword());
        signInPage.submitSignIn();
        signInPage.verifyUserSignedIn(data.getExpectedUsername());
    }

    @ParameterizedTest
    @MethodSource("com.softserve.homework.edu08.SignInDataRepository#invalidSignInData")
    public void signInInvalidEmail(SignInData data) {
        logger.debug("Start signInInvalidEmail()");
        signInPage.clickSignInButton();
        signInPage.verifySignInModal();
        signInPage.enterCredentials(data.getEmail(), data.getPassword());
        signInPage.submitSignIn();
        signInPage.verifyErrorMessage(data.getExpectedErrorMessage());
    }
}
