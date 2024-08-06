

package com.example.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.example.pages.HomePage;
import com.example.pages.SearchPage;

public class TableOperationsTest {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://testfire.net/");

        HomePage homePage = new HomePage(driver);
        System.out.println("Login Link Text: " + homePage.getLoginLinkText());
        
        homePage.search("bank");
        
        SearchPage searchPage = new SearchPage(driver);
        System.out.println("Search Page Text: " + searchPage.getSearchPageText());
        
        driver.navigate().back();
        
        List<WebElement> links = driver.findElements(By.xpath("/html/body/table/tbody/tr[2]/td[2]//a"));
        int size = links.size();
        System.out.println("Number of Links: " + size);
        
       for (WebElement el : links) {
          System.out.println("Is Displayed: " + el.isDisplayed());
           System.out.println("Is Enabled: " + el.isEnabled());
            el.click();
            Thread.sleep(5000);
           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // 20 seconds timeout
            WebElement pageContent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[9]")));
            System.out.println("9th TD Text: " + pageContent.getText());
            
         List<WebElement> pageLinks = driver.findElements(By.xpath("(//td)[9]//a"));
         for(WebElement link:pageLinks) {
        	 System.out.println("afaffa    "+link.getText());
        	 link.click();
        	 Thread.sleep(3000);
        	 driver.navigate().back();
         }
         System.out.println("Page Links: " + pageLinks);
         driver.navigate().back();
           }
      List<WebElement> catalinks = driver.findElements(By.xpath("//td[@class='cc br bb']/a"));
      for(WebElement cata:catalinks) {
    	  cata.click();
    	  Thread.sleep(5000);
    	  System.out.println(driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]")).getText());
    	  driver.navigate().back();
    	  
    	  
      }
       

        
    }
}
