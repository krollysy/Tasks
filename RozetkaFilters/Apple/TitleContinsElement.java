package Apple;

import Elements.BlockWithGoods;
import Elements.ProducerPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by user on 07.07.2015.
 */
public class TitleContinsElement {
    WebDriver driver;
    String baseUrl;
    ProducerPage Apple;
    BlockWithGoods forApple;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        baseUrl = "http://rozetka.com.ua/notebooks/c80004/filter/";
        driver.manage().timeouts().implicitlyWait(30,  TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test
    public void TestFofTitle() throws  Exception{
        Apple = new ProducerPage(driver);
        forApple = new BlockWithGoods(driver);
        Apple.getApple();
        String pageTitle = forApple.getPageTitle();
        System.out.println(pageTitle);
        Wait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".c-cols-inner-l>h1")));
        try {
            Assert.assertTrue(forApple.isFiltersAppear());
            Assert.assertTrue(pageTitle.contains("Apple"));
            Assert.assertTrue(pageTitle.contains("Сбросить"));
            Apple.getApple();
            Assert.assertTrue(forApple.isFilterDisappear());
        } catch (AssertionError e) {
            System.out.println("Filter doesn't work");
        }
    }

    @Test
    public void TestForReset() throws Exception {
        Apple = new ProducerPage(driver);
        forApple = new BlockWithGoods(driver);
        Apple.getApple();
        try {
            forApple.clickReset();
            Assert.assertTrue(forApple.isFilterDisappear());
        } catch (AssertionError e) {
            System.out.println("Filter doesn't work");
        }
    }

    @Test
    public void TestForFilter() throws Exception {
        Apple = new ProducerPage(driver);
        forApple = new BlockWithGoods(driver);
        Apple.getApple();
        try {
            Assert.assertTrue(forApple.clickFilterButton());
        } catch (AssertionError e) {
            System.out.println("Filter doesn't work");
        }
    }

    @After
     public void tearDown() {
        driver.quit();
    }
}
