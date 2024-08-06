package com.example.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    @FindBy(id = "LoginLink")
    WebElement loginLink;

    @FindBy(id = "LoginLink")
    WebElement searchBox;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getLoginLinkText() {
        return loginLink.getText();
    }

    public void search(String query) {
        searchBox.sendKeys(query + Keys.ENTER);
    }
}
