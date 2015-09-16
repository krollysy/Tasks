package org.openqa.selenium.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

/**
 * Created by Оксана on 08.06.2015.
 */
public class GoogleResultPage extends Page{
    public GoogleResultPage(WebDriver driver) {
        super(driver);
    }
    WebElement q;
   /* @FindBy(className = "sbdd_b")
    private WebElement sbdd_b;*/

    /*@FindBy
    @FindBy(className = "./*//*[@id='sbtc']/div[2]/div[2]/div"*//*"//div[@id='sbtc']/div[2]/div[2]/div[1]"*//*)
     List<WebElement> allSuggestions;*/


    public String getAt(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver.findElement(By.cssSelector("#resultStats")).getText();
    }
    public String getEl(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        q.click();
        return driver.findElement(By.cssSelector(".sbdd_b")).getText();
    }
}
