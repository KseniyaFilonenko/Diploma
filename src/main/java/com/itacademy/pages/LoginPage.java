package com.itacademy.pages;

import com.itacademy.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
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
        PageFactory.initElements(driver, this);
    }
    public void typeValidLogin(String validLogin){
        loginField.sendKeys(validLogin);
    }
    public void typeInvalidLogin(String invalidLogin){
        loginField.sendKeys(invalidLogin);
    }
    public void typeValidPassword(String validPassword){
        passwordField.sendKeys(validPassword);
    }
    public void typeInvalidPassword(String invalidPassword){
        passwordField.sendKeys(invalidPassword);
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
