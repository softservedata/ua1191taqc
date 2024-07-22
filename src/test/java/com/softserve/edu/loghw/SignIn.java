package com.softserve.edu.loghw;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SignIn {
    private final WebDriverWait wait;
    private WebDriver driver;
    private JavascriptExecutor javascriptExecutor;
    private boolean isSignInFormOpened = false;

    public SignIn(WebDriver driver) {
        this.driver = driver;
        this.javascriptExecutor = (JavascriptExecutor) driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void openSignInForm() throws InterruptedException {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .ignoring(NoSuchElementException.class)
                .ignoring(NullPointerException.class)
                .ignoring(TimeoutException.class);
        WebElement signInButton = wait.until(ExpectedConditions
                .elementToBeClickable(By.cssSelector("div.main-content.app-container img.ubs-header-sing-in-img.ng-star-inserted")));
        if (!isSignInFormOpened) {
            signInButton.click();
            isSignInFormOpened = true;
            Thread.sleep(2000);
        }
    }

    public void signIn(String email, String password) throws InterruptedException {
        if (!isSignInFormOpened) {
            openSignInForm();
        }

        WebElement welcomeText = (WebElement) (javascriptExecutor.executeScript("return document.querySelector('div.container h1')"));
        assertThat(welcomeText.getText().trim(), is("З поверненням!"));
        WebElement signInDetailsText = (WebElement) (javascriptExecutor.executeScript("return document.querySelector('div.container h2')"));
        assertThat(signInDetailsText.getText(), is("Будь ласка, внесiть свої дані для входу."));
        WebElement emailLabel = (WebElement) (javascriptExecutor.executeScript("return document.querySelector(\"form.sign-in-form label[for='email']\")"));
        assertThat(emailLabel.getText(), is("Електронна пошта"));

        WebElement emailInput = (WebElement) (javascriptExecutor.executeScript("return document.getElementById('email')"));

        emailInput.clear();
        emailInput.sendKeys(email);
        Thread.sleep(1000);
        assertThat(emailInput.getAttribute("value"), is(email));

        WebElement passwordInput = (WebElement) (javascriptExecutor.executeScript("return document.getElementById('password')"));
        WebElement signInSubmitButton = (WebElement) (javascriptExecutor.executeScript("return document.querySelector('.ubsStyle')"));
        passwordInput.clear();
        passwordInput.sendKeys(password);
        Thread.sleep(1000);
        assertThat(passwordInput.getAttribute("value"), is(password));

        waitForElementToBeClickable(signInSubmitButton);

        signInSubmitButton.click();
    }

    public void signInNotValid(String email, String message) throws InterruptedException {
        openSignInForm();
        WebElement emailInput = (WebElement) (javascriptExecutor.executeScript("return document.getElementById('email')"));
        WebElement passwordInput = (WebElement) (javascriptExecutor.executeScript("return document.getElementById('password')"));

        emailInput.clear();
        emailInput.sendKeys(email);
        passwordInput.clear();
        passwordInput.sendKeys("uT346^^^erw");
        WebElement errorEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"email-err-msg\"]/app-error/div")));
        assertThat(errorEmail.getText(), is(message));
    }

    private void waitForElementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void isFieldDisplayed(String fieldName, boolean isDisplayed) throws InterruptedException {
        openSignInForm();
        WebElement emailInput = (WebElement) (javascriptExecutor.executeScript("return document.getElementById('email')"));
        WebElement passwordInput = (WebElement) (javascriptExecutor.executeScript("return document.getElementById('password')"));
        WebElement signInSubmitButton = (WebElement) (javascriptExecutor.executeScript("return document.querySelector('.ubsStyle')"));
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
