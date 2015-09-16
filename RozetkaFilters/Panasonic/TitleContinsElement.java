package Panasonic;

import Elements.BlockWithGoods;
import Elements.ProducerPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by user on 08.07.2015.
 */
public class TitleContinsElement {
    WebDriver driver;
    String baseUrl;
    ProducerPage Panasonic;
    BlockWithGoods forPanasonic;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        baseUrl = "http://rozetka.com.ua/notebooks/c80004/filter/";
        driver.manage().timeouts().implicitlyWait(30,  TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test
    public void TestFofTitle() throws  Exception{
        Panasonic = new ProducerPage(driver);
        forPanasonic = new BlockWithGoods(driver);
        Panasonic.getPanasonic();
        String pageTitle = forPanasonic.getPageTitle();
        System.out.println(pageTitle);
        Wait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".c-cols-inner-l>h1")));

        try {
            Assert.assertTrue(forPanasonic.isFiltersAppear());
            Assert.assertTrue(pageTitle.contains("Panasonic"));
            Assert.assertTrue(pageTitle.contains("Сбросить"));
            Panasonic.getPanasonic();
            Assert.assertTrue(forPanasonic.isFilterDisappear());
        } catch (AssertionError e) {
            System.out.println("Filter doesn't work");
        }
    }

    @Test
    public void TestForReset() throws Exception {
        Panasonic = new ProducerPage(driver);
        forPanasonic = new BlockWithGoods(driver);
        Panasonic.getPanasonic();
        try {
            forPanasonic.clickReset();
            Assert.assertTrue(forPanasonic.isFilterDisappear());
        } catch (AssertionError e) {
            System.out.println("Filter doesn't work");
        }
    }

    @Test
    public void TestForFilter() throws Exception {
        Panasonic = new ProducerPage(driver);
        forPanasonic = new BlockWithGoods(driver);
        Panasonic.getPanasonic();
        try {
            Assert.assertTrue(forPanasonic.clickFilterButton());
        } catch (AssertionError e) {
            System.out.println("Filter doesn't work");
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
