package com.softserve.edu.testconstrhw;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class TestSamples3 extends TestRunner {

    private SignIn signIn;

    @BeforeEach
    public void setupThis() {
        signIn = new SignIn(driver);
    }

    @ParameterizedTest
    @CsvSource({
            "GreenCity"
    })
    public void verifyTitle(String title) {
        Assertions.assertEquals(title, driver.getTitle());
        assertThat(driver.getTitle(), is(title));
    }

    @ParameterizedTest
    @CsvSource({
            "emailInput, true",
            "passwordInput, true",
            "signInSubmitButton, true"
    })
    public void verifyMandatoryFields(String fieldName, boolean isDisplayed) {
        signIn.isFieldDisplayed(fieldName, isDisplayed);
    }

    @ParameterizedTest
    @CsvSource({
            "samplestest@greencity.com, weyt3$Guew^",
            "anotheruser@greencity.com, anotherpassword"
    })
    public void signIn(String email, String password) throws InterruptedException {
        signIn.signIn(email, password);
    }

    @ParameterizedTest
    @CsvSource({
            "samplestesgreencity.com, Перевірте коректність введеної електронної адреси"
    })
    public void signInNotValid(String email, String message) {
        signIn.signInNotValid(email, message);
    }

}