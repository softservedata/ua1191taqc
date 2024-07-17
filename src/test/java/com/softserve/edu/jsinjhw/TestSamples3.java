package com.softserve.edu.jsinjhw;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.BasicConfigurator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class TestSamples3 {
    //@FindBy(id = "email")
    //private WebElement emailInput;
    //@FindBy(id = "password")
    //private WebElement passwordInput;
    //@FindBy(css = ".ubsStyle")
    //private WebElement signInSubmitButton;
    //@FindBy(css = ".mat-simple-snackbar > span")
    //private WebElement result;
    //@FindBy(css = ".alert-general-error")
    //private WebElement errorMessage;
   // @FindBy(xpath = "//*[@id=\"password-err-msg\"]/app-error/div")
   // private WebElement errorPassword;
    JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
    WebElement emailInput = (WebElement) (javascriptExecutor.executeScript("return document.getElementById('email')"));
    WebElement passwordInput = (WebElement) (javascriptExecutor.executeScript("return document.getElementById('password')"));
    WebElement signInSubmitButton = (WebElement) (javascriptExecutor.executeScript("return document.querySelector('.ubsStyle')"));

    @FindBy(xpath = "//*[@id=\"email-err-msg\"]/app-error/div")
    private WebElement errorEmail;
    @FindBy(css = ".header_navigation-menu-ubs ul a.pick-up-service")
    private List<WebElement> aboutService;
    @FindBy(css = "div.header_navigation-menu-ubs ul[role='tablist'] a[href='https://nowaste.com.ua/sort-station/']")
    private List<WebElement> sortRules;
    @FindBy(css = "div.header_navigation-menu-ubs ul[role='tablist'] a[href='https://shop.nowaste.com.ua/']")
    private List<WebElement> ecoShop;
    @FindBy(css = "div.header_navigation-menu-ubs ul[role='tablist'] a[href='#/greenCity']")
    private List<WebElement> greenCity;

    private static WebDriver driver;
    private static boolean isSignInFormOpened = false;


    @BeforeAll
    public static void setUp() {
        BasicConfigurator.configure();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.greencity.cx.ua/#/ubs");
        driver.manage().window().setSize(new Dimension(1264, 798));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void waitForElementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    @BeforeEach
    public void initPageElements() {
        PageFactory.initElements(driver, this);
    }

    @ParameterizedTest
    @CsvSource({
            "GreenCity"
    })
    public void verifyTitle(String title) {
        Assertions.assertEquals(title, driver.getTitle());
        assertThat(driver.getTitle(), is(title));
    }

    //My test
    @ParameterizedTest
    @CsvSource({
            "1, Про Сервіс",
    })
    public void testAboutService(int index, String expectedSubstring) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement serviceLink = aboutService.get(index);
        wait.until(ExpectedConditions.elementToBeClickable(serviceLink)).click();

        String elementText = serviceLink.getText();
        assertThat(elementText, containsString(expectedSubstring));

        driver.get("https://www.greencity.cx.ua/#/ubs");
    }

    //My test
    @ParameterizedTest
    @CsvSource({
            "sortRules, https://nowaste.com.ua/sort-station/",
            "ecoShop, https://shop.nowaste.com.ua/",
            "greenCity, https://www.greencity.cx.ua/#/greenCity"
    })
    public void testNavigation(String linkType, String expectedUrl) {
        List<WebElement> links = null;
        switch (linkType) {
            case "sortRules":
                links = sortRules;
                break;
            case "ecoShop":
                links = ecoShop;
                break;
            case "greenCity":
                links = greenCity;
                break;
            default:
                Assertions.fail("Unexpected link type: " + linkType);
        }

        for (int i = 0; i < links.size(); i++) {
            WebElement link = links.get(i);
            String actualUrl = getLink(link);
            assertThat(actualUrl, containsString(expectedUrl));
        }
    }


    private String getLink(WebElement element) {
        return element.getAttribute("href");
    }


    //My test
    @ParameterizedTest
    @CsvSource({
            "emailInput, true",
            "passwordInput, true",
            "signInSubmitButton, true"
    })
    public void verifyMandatoryFields(String fieldName, boolean isDisplayed) {
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
        }

        //JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        //WebElement emailInput = (WebElement) (javascriptExecutor.executeScript("return document.getElementById('email')"));
        //WebElement passwordInput = (WebElement) (javascriptExecutor.executeScript("return document.getElementById('password')"));
        //WebElement signInSubmitButton = (WebElement) (javascriptExecutor.executeScript("return document.querySelector('.ubsStyle')"));
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

    @ParameterizedTest
    @CsvSource({
            "samplestest@greencity.com, weyt3$Guew^",
            "anotheruser@greencity.com, anotherpassword"
    })
    public void signIn(String email, String password) throws InterruptedException {
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
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement welcomeText = (WebElement) (js.executeScript("return document.querySelector('div.container h1')"));
        assertThat(welcomeText.getText().trim(), is("З поверненням!"));
        WebElement signInDetailsText = (WebElement) (js.executeScript("return document.querySelector('div.container h2')"));
        assertThat(signInDetailsText.getText(), is("Будь ласка, внесiть свої дані для входу."));
        WebElement emailLabel = (WebElement) (js.executeScript("return document.querySelector(\"form.sign-in-form label[for='email']\")"));
        assertThat(emailLabel.getText(), is("Електронна пошта"));

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
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


    @ParameterizedTest
    @CsvSource({
            "samplestesgreencity.com, Перевірте коректність введеної електронної адреси"
    })
    public void signInNotValid(String email, String message) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        WebElement emailInput = (WebElement) (javascriptExecutor.executeScript("return document.getElementById('email')"));
        WebElement passwordInput = (WebElement) (javascriptExecutor.executeScript("return document.getElementById('password')"));

        emailInput.clear();
        emailInput.sendKeys(email);
        passwordInput.clear();
        passwordInput.sendKeys("uT346^^^erw");
        assertThat(errorEmail.getText(), is(message));
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}