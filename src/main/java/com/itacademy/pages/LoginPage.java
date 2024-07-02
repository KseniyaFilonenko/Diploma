package com.itacademy.pages;

import com.itacademy.utils.ScreenshotUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }
    public void typeLogin(String loginValue){
        ScreenshotUtils.saveScreenshot(driver);
        wait.until(ExpectedConditions.visibilityOf(loginField));
        ScreenshotUtils.saveScreenshot(driver);
        loginField.sendKeys(loginValue);
        ScreenshotUtils.saveScreenshot(driver);
    }
    public void typePassword(String passwordValue){
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        ScreenshotUtils.saveScreenshot(driver);
        passwordField.sendKeys(passwordValue);
        ScreenshotUtils.saveScreenshot(driver);
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
