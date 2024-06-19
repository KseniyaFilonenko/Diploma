package com.itacademy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.Duration;

public class LoginPage extends BasePage {
    private WebDriverWait wait;
    @FindBy(xpath = "//*[@name='USER_LOGIN']")
    private WebElement loginField;
    @FindBy(xpath = "//*[@name='USER_PASSWORD']")
    private WebElement passwordField;
    @FindBy(xpath = "//*[@name='Login']")
    private WebElement enterButton;
    @FindBy(xpath = "//p[text()='Вы зарегистрированы и успешно авторизовались.']")
    private WebElement successLoginMessage;
    @FindBy(xpath = "//div[contains(@class, 'alert alert-danger')]")
    private WebElement failedLoginMessage;
    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
    public void typeLogin(String loginValue){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        wait.until(ExpectedConditions.visibilityOf(loginField));
        saveScreenshot(driver);
        loginField.sendKeys(loginValue);
        saveScreenshot(driver);
    }
    public void typePassword(String passwordValue){
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys(passwordValue);
    }
    public void clickEnterButton(){
        enterButton.click();
    }
    public String getSuccessLoginMessage(){
        return successLoginMessage.getText();
    }
    public String expectedSuccessLoginMessage(){
        return "Вы зарегистрированы и успешно авторизовались.";
    }
    public String getFailedLoginMessage(){
        return failedLoginMessage.getText();
    }
    public String expectedFailedLoginMessage(){
        return "Неверный логин или пароль.";
    }
}
