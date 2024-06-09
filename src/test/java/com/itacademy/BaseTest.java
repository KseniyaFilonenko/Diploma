package com.itacademy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.time.Duration;

import static com.codeborne.selenide.Configuration.browser;

public class BaseTest {
    protected WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setUp() {
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
    }
    @AfterTest
    public void closeSession() {
        driver.quit();
    }
}
