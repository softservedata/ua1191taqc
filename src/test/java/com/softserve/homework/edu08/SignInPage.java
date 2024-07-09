package com.softserve.homework.edu08;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SignInPage {
    private WebDriver driver;
    private JavascriptExecutor js;
    private WebDriverWait wait;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void clickSignInButton() {
        js.executeScript("document.querySelector('app-header:nth-child(1) .ubs-header-sign-in').click();");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#mat-mdc-dialog-0 .right-side app-sign-in h1")));
    }

    public void verifySignInModal() {
        assertThat(driver.findElement(By.cssSelector("#mat-mdc-dialog-0 .right-side app-sign-in h1")).getText(), is("Welcome back!"));
        assertThat(driver.findElement(By.cssSelector("h2:nth-child(2)")).getText(), is("Please enter your details to sign in."));
        assertThat(driver.findElement(By.cssSelector("#mat-mdc-dialog-0 .right-side app-sign-in form label:first-of-type")).getText(), is("Email"));
    }

    public void enterCredentials(String email, String password) {
        WebElement emailInput = (WebElement) js.executeScript("return document.getElementById('email');");
        WebElement passwordInput = (WebElement) js.executeScript("return document.getElementById('password');");

        emailInput.sendKeys(email);
        assertThat(emailInput.getAttribute("value"), is(email));

        passwordInput.sendKeys(password);
        assertThat(passwordInput.getAttribute("value"), is(password));
    }

    public void submitSignIn() {
        js.executeScript("document.querySelector('.ubsStyle').click();");
    }

    public void verifyUserSignedIn(String expectedUsername) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#header_user-wrp > li")));
        assertThat(driver.findElement(By.cssSelector("#header_user-wrp > li")).getText(), is(expectedUsername));
    }

    public void verifyErrorMessage(String expectedErrorMessage) {
        if (expectedErrorMessage.equals("Please check if the email is written correctly")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#email-err-msg > app-error > div")));
            assertThat(driver.findElement(By.cssSelector("#email-err-msg > app-error > div")).getText(), is(expectedErrorMessage));
        } else if (expectedErrorMessage.equals("Bad email or password")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#mat-mdc-dialog-0 > div > div > app-auth-modal > div > div > div.right-side > div > app-sign-in > div > div:nth-child(1) > form > div.alert-general-error.ng-star-inserted")));
            assertThat(driver.findElement(By.cssSelector("#mat-mdc-dialog-0 > div > div > app-auth-modal > div > div > div.right-side > div > app-sign-in > div > div:nth-child(1) > form > div.alert-general-error.ng-star-inserted")).getText(), is(expectedErrorMessage));
        }
    }
}
