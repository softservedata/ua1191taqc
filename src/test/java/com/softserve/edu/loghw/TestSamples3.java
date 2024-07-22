package com.softserve.edu.loghw;

import com.softserve.edu.testconstrhw.SignIn;
import com.softserve.edu.testconstrhw.TestRunner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class TestSamples3 extends TestRunner {

    private com.softserve.edu.testconstrhw.SignIn signIn;
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @BeforeEach
    public void setupThis() {
        super.setupThis();
        signIn = new SignIn(driver);
    }

    @ParameterizedTest
    @CsvSource({
            "GreenCity"
    })
    public void verifyTitle(String title) {
        logger.info("Starting test: verifyTitle");
        Assertions.assertEquals(title, driver.getTitle());
        assertThat(driver.getTitle(), is(title));
    }

    @ParameterizedTest
    @CsvSource({
            "emailInput, true",
            "passwordInput, true",
            "signInSubmitButton, true"
    })
    public void verifyMandatoryFields(String fieldName, boolean isDisplayed) throws InterruptedException {
        logger.info("Starting test: verifyMandatoryFields");
        signIn.isFieldDisplayed(fieldName, isDisplayed);
    }

    @ParameterizedTest
    @CsvSource({
            "samplestest@greencity.com, weyt3$Guew^",
            "anotheruser@greencity.com, anotherpassword"
    })
    public void signIn(String email, String password) throws InterruptedException {
        logger.info("Starting test: signIn");
        signIn.signIn(email, password);
    }

    @ParameterizedTest
    @CsvSource({
            "samplestesgreencity.com, Перевірте коректність введеної електронної адреси"
    })
    public void signInNotValid(String email, String message) throws InterruptedException {
        logger.info("Starting test: signInNotValid");
        signIn.signInNotValid(email, message);
    }

}