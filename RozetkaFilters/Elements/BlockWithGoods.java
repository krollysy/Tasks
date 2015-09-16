package Elements;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.internal.Streams;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by user on 04.07.2015.
 */
public class BlockWithGoods {
    private WebDriver driver;

    By blockWithMainElements = By.className("over-wraper");
    By notDisplayedElements = By.name("more_goods");
    By pages = By.xpath("//div[@id='right_column']/div/div[1]/div[2]/div/h3");
    By textOfElements = By.cssSelector(".g-i-tile-i-title.clearfix>a");
    By pageTitle = By.cssSelector(".filter-active-l.clearfix");
    By countOfElementsChoosen = By.cssSelector(".filter-active-i>p");
    By resetButton = By.cssSelector(".filter-active-i-link.novisited.filter-active-i-link-reset.sprite-side");
    By filterButtons = By.cssSelector(".filter-active-i-link.novisited.sprite-side");
    By price = By.cssSelector(".g-price-uah");

    List<WebElement> allGoods = null;
    List<WebElement> allNText = null;
    List<String> textsOfAllElements = new ArrayList<String>();
    List<Integer> priceOfAllElements = new ArrayList<Integer>();

    public BlockWithGoods(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getListOfPrices() {
        while(true) {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.presenceOfElementLocated(pages));
            allGoods = driver.findElements(price);
            Actions actions = new Actions(driver);
            actions.moveToElement(driver.findElement(pages));
            try {
                driver.findElement(notDisplayedElements).click();
            } catch (Exception e) {
                break;
            }
        }
        return allGoods;
    }

    public List<Integer> getAllPrices(List<WebElement> list) {
        int i = 0;
        for (WebElement el : list) {
            String s = el.getText().toString();
            char [] arr = s.toCharArray();
            String str = "";
            for (char c : arr){
                if (Character.isDigit(c)) {
                    str += c;
                }
            }
            priceOfAllElements.add(i, Integer.parseInt(str));
            i++;
        }
         Collections.sort(priceOfAllElements);
        /*for (Integer in : priceOfAllElements) {
            System.out.println(in);
        }*/
         return priceOfAllElements;
    }


    public List getNamesOfElements() {
        while(true) {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.presenceOfElementLocated(pages));
            allNText = driver.findElements(textOfElements);
            Actions actions = new Actions(driver);
            actions.moveToElement(driver.findElement(pages));
            try {
                driver.findElement(notDisplayedElements).click();
            } catch (Exception e) {
                break;
            }
        }
        return allNText;
    }

    public List getTextsOfElements(List<WebElement> list) {
        int i = 0;
        for (WebElement el : list) {
            String s = el.getText().toString();
            textsOfAllElements.add(i, s);
            i++;
        }
        return textsOfAllElements;
    }

    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }

    public boolean isFiltersAppear () {
        try {
            if (driver.findElement(pageTitle).isEnabled() == true) {
                return true;
            } else {
                return false;
            }
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isFilterDisappear() {
        try {
            if (driver.findElement(pageTitle).isEnabled() == true) {
                return false;
            } else {
                return true;
            }
        } catch (NoSuchElementException e) {
            return true;
        }
    }

    public int getNumberOfCountElements() {
        String str = "";
        String [] arrStr = driver.findElement(countOfElementsChoosen).getText().split(" ");
        char [] arrChars = arrStr[1].toCharArray();
        for (char c : arrChars) {
            if (Character.isDigit(c) == true) {
                str += c;
            }
        }
        return Integer.parseInt(str);
    }

    public void clickReset() {
        driver.findElement(resetButton).click();
    }

    public boolean clickFilterButton() {
        try {
            driver.findElement(filterButtons).click();
            if (driver.findElement(filterButtons).isEnabled()) {
                return false;
            } else {
                return true;
            }
        } catch (NoSuchElementException e) {
            return true;
        }
    }
}
