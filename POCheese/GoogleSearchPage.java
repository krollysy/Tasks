package org.openqa.selenium.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Оксана on 08.06.2015.
 */
public class GoogleSearchPage extends Page{

    public GoogleSearchPage(WebDriver driver) {
        super(driver);
    }

    private WebElement q;
    private WebElement btnG;

    public GoogleResultPage search(String searchText) {
        q.sendKeys(searchText);
        btnG.click();
        return PageFactory.initElements(driver, GoogleResultPage.class);
    }
}
