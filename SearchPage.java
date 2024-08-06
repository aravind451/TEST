package com.example.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
    WebDriver driver;

    @FindBy(xpath = "/html/body/table/tbody/tr[2]/td[2]/div")
    WebElement searchPageText;

    @FindAll({
        @FindBy(xpath = "//a") // Find all <a> elements
    })
    List<WebElement> links;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getSearchPageText() {
        return searchPageText.getText();
    }

    public List<WebElement> getLinks() {
        return links;
    }
}
