package MainTests;

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

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by user on 05.07.2015.
 */
public class TestsForAcer {
    WebDriver driver;
    String baseUrl;
    List<WebElement> listWithElements;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        baseUrl = "http://rozetka.com.ua/notebooks/c80004/filter/";
        driver.manage().timeouts().implicitlyWait(30,  TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test
    public void Test() throws  Exception{
        ProducerPage Acer;
        BlockWithGoods forAcer;
        Acer = new ProducerPage(driver);
        forAcer = new BlockWithGoods(driver);
        Acer.getAcer();
        String pageTitle = forAcer.getPageTitle();
        System.out.println(pageTitle);
        Wait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".c-cols-inner-l>h1")));
        Assert.assertTrue(pageTitle.contains("Acer"));
    }

    @Test
    public void TestContainsElement() throws Exception{
        ProducerPage Acer = new ProducerPage(driver);
        BlockWithGoods forAcer = new BlockWithGoods(driver);
        Acer.getAcer();
        listWithElements = forAcer.getNamesOfElements();
        List<String> listWithTitles = forAcer.getTextsOfElements(listWithElements);
        for(String li : listWithTitles) {
            Assert.assertTrue(li.contains("Acer"));
        }
    }

    @Test
    public void TestCountOfElements() throws Exception {
        ProducerPage Acer = new ProducerPage(driver);
        BlockWithGoods forAcer = new BlockWithGoods(driver);
        int resultCountOfElements = Acer.getAcersNumber();
        Acer.getAcer();
        listWithElements = forAcer.getNamesOfElements();
        Assert.assertTrue(listWithElements.size() == resultCountOfElements);
    }

    @Test
    public void TestCompateCountWithTitle() {
        ProducerPage Acer = new ProducerPage(driver);
        BlockWithGoods forAcer = new BlockWithGoods(driver);
        Acer.getAcer();
        int resultCountOfElements = forAcer.getNumberOfCountElements();
        listWithElements = forAcer.getNamesOfElements();
        Assert.assertTrue(listWithElements.size() == resultCountOfElements);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
