package com.itacademy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class SearchPage extends BasePage{
    @FindBy(xpath = "//*[contains(@class, 'form-control') and contains(@placeholder, 'Поиск по каталогу')]")
    private WebElement searchField;
    @FindBy(xpath = "//*[@class='catalog-list']")
    private List<WebElement> listOfFoundProducts;
    @FindBy(xpath = "//*[contains(@type,'submit') and contains(@class,'submit')]")
    private WebElement searchIcon;
    public SearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void typeSearchField(String searchText){
        searchField.sendKeys(searchText);
    }
    public void clickSearchIcon(){
        searchIcon.click();
    }
    public List<String> getFoundProductsList() {
        return listOfFoundProducts.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
    public boolean findProduct(String searchedTitle){
        for (WebElement product : listOfFoundProducts) {
            if (product.getText().contains(searchedTitle)) {
                return true;
            }
        }
        return false;
    }
}

