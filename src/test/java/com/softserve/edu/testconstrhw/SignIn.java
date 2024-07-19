package com.softserve.edu.testconstrhw;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SignIn {
    private WebDriver driver;
    private JavascriptExecutor javascriptExecutor;

    @FindBy(css = "div.main-content.app-container img.ubs-header-sing-in-img.ng-star-inserted")
    private WebElement signInButton;

    @FindBy(css = "div.container h1")
    private WebElement welcomeText;

    @FindBy(css = "div.container h2")
    private WebElement signInDetailsText;

    @FindBy(css = "form.sign-in-form label[for='email']")
    private WebElement emailLabel;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(css = ".ubsStyle")
    private WebElement signInSubmitButton;

    @FindBy(xpath = "//*[@id=\"email-err-msg\"]/app-error/div")
    private WebElement errorEmail;

    private boolean isSignInFormOpened = false;

    public SignIn(WebDriver driver) {
        this.driver = driver;
        this.javascriptExecutor = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    public void openSignInForm() {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .ignoring(NoSuchElementException.class)
                .ignoring(NullPointerException.class)
                .ignoring(TimeoutException.class);
        signInButton = wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        if (!isSignInFormOpened) {
            signInButton.click();
            isSignInFormOpened = true;
        }
    }

    public void signIn(String email, String password) throws InterruptedException {
        openSignInForm();
        Thread.sleep(2000);

        assertThat(welcomeText.getText().trim(), is("З поверненням!"));
        assertThat(signInDetailsText.getText(), is("Будь ласка, внесiть свої дані для входу."));
        assertThat(emailLabel.getText(), is("Електронна пошта"));

        emailInput.clear();
        emailInput.sendKeys(email);
        Thread.sleep(1000);
        assertThat(emailInput.getAttribute("value"), is(email));

        passwordInput.clear();
        passwordInput.sendKeys(password);
        Thread.sleep(1000);
        assertThat(passwordInput.getAttribute("value"), is(password));

        waitForElementToBeClickable(signInSubmitButton);
        signInSubmitButton.click();
    }

    public void signInNotValid(String email, String message) {
        emailInput.clear();
        emailInput.sendKeys(email);
        passwordInput.clear();
        passwordInput.sendKeys("uT346^^^erw");
        assertThat(errorEmail.getText(), is(message));
    }

    private void waitForElementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void isFieldDisplayed(String fieldName, boolean isDisplayed) {
        openSignInForm();
        switch (fieldName) {
            case "emailInput":
                assertThat(emailInput.isDisplayed(), is(isDisplayed));
                break;
            case "passwordInput":
                assertThat(passwordInput.isDisplayed(), is(isDisplayed));
                break;
            case "signInSubmitButton":
                assertThat(signInSubmitButton.isDisplayed(), is(isDisplayed));
                break;
        }
    }
}
