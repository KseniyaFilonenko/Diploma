package com.itacademy;

import com.itacademy.pages.HomePage;
import com.itacademy.pages.LoginPage;
import com.itacademy.pages.SearchPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebsiteTest extends BaseTest{
    private static final Logger LOGGER = LogManager.getLogger(WebsiteTest.class);
    @Test
    public void verifyValidLogin(){
        HomePage homePage = new HomePage(driver);
        homePage.openUrl();
        homePage.openLoginPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeLogin("filonenko_k@tut.by");
        loginPage.typePassword("filonenko1234");
        loginPage.clickEnterButton();
        Assert.assertEquals(loginPage.getSuccessLoginMessage(), loginPage.expectedSuccessLoginMessage());
    }
    @Test
    public void verifyInvalidLogin(){
        HomePage homePage = new HomePage(driver);
        homePage.openUrl();
        homePage.openLoginPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeLogin("k@tut.by");
        loginPage.typePassword("filonenko1234");
        loginPage.clickEnterButton();
        Assert.assertEquals(loginPage.getFailedLoginMessage(), loginPage.expectedFailedLoginMessage());
    }
    @Test
    public void verifyInvalidPassword(){
        HomePage homePage = new HomePage(driver);
        homePage.openUrl();
        homePage.openLoginPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeLogin("filonenko_k@tut.by");
        loginPage.typePassword("1234");
        loginPage.clickEnterButton();
        Assert.assertEquals(loginPage.getFailedLoginMessage(), loginPage.expectedFailedLoginMessage());
    }
    @Test
    public void verifySearch(){
        HomePage homePage = new HomePage(driver);
        homePage.openUrl();
        SearchPage searchPage = new SearchPage(driver);
        searchPage.typeSearchField("крем");
        searchPage.clickSearchIcon();
        searchPage.getFoundProductsList();
        searchPage.findProduct("Крем для лица ночной с муцином улитки");
    }
}
