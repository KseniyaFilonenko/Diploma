package com.itacademy;

import com.itacademy.listeners.TestListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

@Listeners(TestListener.class)
public class BaseTest {
    protected WebDriver driver;
    private WebDriverWait wait;
    private static final Logger LOGGER = LogManager.getLogger(BaseTest.class);
    @BeforeMethod
    public void setUp() {
        String browser = System.getProperty("browser");
        LOGGER.info("Browser: " + browser);
        if (browser == null)
            browser = "chrome";
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:/Drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        driver.get("https://belita-shop.by/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @AfterMethod
    public void closeSession() {
        driver.quit();
    }
}
