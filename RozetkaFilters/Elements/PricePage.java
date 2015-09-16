package Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by user on 08.07.2015.
 */
public class PricePage {
    WebDriver driver;
    By minPrice = By.name("price[min]");
    By maxPrice = By.name("price[max]");
    By submitButton = By.cssSelector("#submitprice");

    public PricePage(WebDriver driver) {
        this.driver = driver;
    }

    public void typeMinPrice(String min) {
        driver.findElement(minPrice).sendKeys(min);
    }

    public void typeMaxPrice(String max) {
        driver.findElement(maxPrice).sendKeys(max);
    }

    public void submitPrice() {
        driver.findElement(submitButton).click();
    }

    public int getMinPrise() {
       String s = driver.findElement(minPrice).getAttribute("value");
        int el = Integer.parseInt(s);
        return el;
    }

    public int getMaxPrise() {
        String s = driver.findElement(maxPrice).getAttribute("value");
        int el = Integer.parseInt(s);
        return el;
    }
}
