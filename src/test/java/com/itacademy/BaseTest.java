package com.itacademy;

import com.itacademy.listeners.TestListener;
import com.itacademy.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

@Listeners(TestListener.class)
public class BaseTest {
    protected WebDriver driver;
    private WebDriverWait wait;
    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.createDriver();
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
