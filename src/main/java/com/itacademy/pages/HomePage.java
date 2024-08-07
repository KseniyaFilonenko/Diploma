package com.itacademy.pages;

import com.itacademy.utils.Waiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    @FindBy(xpath = "(//span[text()='Войти'])[2]")
    private WebElement loginButton;

    public HomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void openUrl(){
        driver.get("https://belita-shop.by/");
    }
    public void openLoginPage(){
        Waiters.waitLoadingLoginPage();
        loginButton.click();
    }
}
