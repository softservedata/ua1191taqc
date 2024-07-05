package com.softserve.framework.test;

import com.softserve.framework.data.PropertiesRepository;
import com.softserve.framework.library.GuestFunctions;
import com.softserve.framework.tools.LocalStorageJS;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@ExtendWith(RunnerExtension.class)
public abstract class TestRunner {

    private static final String BASE_URL = "https://www.greencity.cx.ua/#/ubs";
    private static final Long IMPLICITLY_WAIT_SECONDS = 10L;
    private static final Long IMPLICITLY_WAIT_ONE_SECONDS = 1L;
    private static final Long ONE_SECOND_DELAY = 1000L;
    private static final String TIME_TEMPLATE = "yyyy-MM-dd_HH-mm-ss-S";
    protected static GuestFunctions guestFunctions;
    protected static LocalStorageJS localStorageJS;

    private static  String baseUrl;

    protected static WebDriver driver;
    protected static boolean isTestSuccessful = false;
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    // Overload
    public static void presentationSleep() {
        presentationSleep(1);
    }

    // Overload
    public static void presentationSleep(int seconds) {
        try {
            Thread.sleep(seconds * ONE_SECOND_DELAY); // For Presentation ONLY
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void takeScreenShot() {
        logger.debug("Start takeScreenShot()");
        //
        //String currentTime = new SimpleDateFormat(TIME_TEMPLATE).format(new Date());
        LocalDateTime localDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(TIME_TEMPLATE);
        String currentTime = localDate.format(formatter);
        //
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("./" + currentTime + "_screenshot.png"));
        } catch (IOException e) {
            // Log.error
            throw new RuntimeException(e);
        }
    }

    private void takePageSource() {
        logger.debug("Start takePageSource()");
        //
        String currentTime = new SimpleDateFormat(TIME_TEMPLATE).format(new Date());
        String pageSource = driver.getPageSource();
        byte[] strToBytes = pageSource.getBytes();
        Path path = Paths.get("./" + currentTime + "_" + "_source.html.txt");
        try {
            Files.write(path, strToBytes, StandardOpenOption.CREATE);
        } catch (IOException e) {
            // Log.error
            throw new RuntimeException(e);
        }
    }

    protected static void closePopup() {
        presentationSleep(); // For Presentation ONLY
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_ONE_SECONDS)); // 0 by default
        List<WebElement> loginFormCloseButton = driver.findElements(By.cssSelector("img[alt='close button']"));
        System.out.println("loginFormCloseButton.size() = " + loginFormCloseButton.size());
        if (loginFormCloseButton.size() > 0) {
            WebElement closeButton = loginFormCloseButton.get(0);
            loginFormCloseButton.get(0).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0)); // 0 by default
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS));
            wait.until(ExpectedConditions.stalenessOf(closeButton)); //TODO
            presentationSleep(); // WAIT!!! //TODO
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS)); // 0 by default
        presentationSleep(); // For Presentation ONLY
    }

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        //
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--remote-allow-origins=*");
        //driver = new ChromeDriver(options);
        driver = new ChromeDriver();
        //
        //driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_SECONDS, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS)); // 0 by default
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(180));
        driver.manage( ).timeouts().scriptTimeout(Duration.ofSeconds(100));
        driver.manage().window().maximize();
        //driver.manage().window().setSize(new Dimension(800, 550));
        //
        guestFunctions = new GuestFunctions(driver);
        localStorageJS = new LocalStorageJS(driver);
        //
        baseUrl= PropertiesRepository.getBaseUrl();
        if (baseUrl == null) {
            baseUrl = BASE_URL;
        }
        //
        System.out.println("@BeforeAll executed");
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit(); // close()
        }
        System.out.println("@AfterAll executed");
    }

    @BeforeEach
    public void setupThis() {
        //driver.get(BASE_URL);
        driver.get(baseUrl);
        closePopup();
        System.out.println("\t@BeforeEach executed");
    }

    @AfterEach
    public void tearThis(TestInfo testInfo) {
        if (!isTestSuccessful) {
            // Log.error
            logger.error("Test_Name = " + testInfo.getDisplayName() + " failed");
            //
            System.out.println("\t\t\tTest_Name = " + testInfo.getDisplayName() + " fail");
            System.out.println("\t\t\tTest_Method = " + testInfo.getTestMethod() + " fail");
            //
            takeScreenShot();
            takePageSource();
        }
        //
        // Logout. get Username
        //driver.findElement(By.cssSelector("li.body-2")).click();
        //driver.findElement(By.cssSelector("li[aria-label='sign-out'] > a")).click();
        //
        // delete All Cookies;
        driver.manage().deleteAllCookies();
        // TODO delete token
        // window.localStorage.removeItem('accessToken');
        // window.localStorage.removeItem('refreshToken');
        // js.executeScript(String.format("window.localStorage.clear();"));
        //
        // delete All Tokens;
        //localStorageJS.clearLocalStorage();
        localStorageJS.removeItemFromLocalStorage("accessToken");
        localStorageJS.removeItemFromLocalStorage("refreshToken");
        //
        // Refresh page
        presentationSleep(4); // For Presentation ONLY
        driver.navigate().refresh();
        presentationSleep(1); // For Presentation ONLY
        //
        System.out.println("\t@AfterEach executed");
    }

}