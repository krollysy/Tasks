package org.openqa.selenium.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Оксана on 08.06.2015.
 */
public class TeatMain {
    public static void main(String [] args){
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com.ua/?gws_rd=ssl");
        GoogleSearchPage search = PageFactory.initElements(driver, GoogleSearchPage.class);
        GoogleResultPage result = search.search("Cheese");
        System.out.println(result.getAt());
        System.out.println(result.getEl());
        driver.quit();
    }
}
