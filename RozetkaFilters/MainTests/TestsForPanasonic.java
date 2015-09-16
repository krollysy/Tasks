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
 * Created by user on 06.07.2015.
 */
public class TestsForPanasonic {
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
        ProducerPage Panasonic;
        BlockWithGoods forPanasonic;
        Panasonic = new ProducerPage(driver);
        forPanasonic = new BlockWithGoods(driver);
        Panasonic.getPanasonic();
        String pageTitle = forPanasonic.getPageTitle();
        System.out.println(pageTitle);
        Wait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".c-cols-inner-l>h1")));
        Assert.assertTrue(pageTitle.contains("Panasonic"));
    }

    @Test
    public void TestContainsElement() throws Exception{
        ProducerPage Panasonic = new ProducerPage(driver);
        BlockWithGoods forPanasonic = new BlockWithGoods(driver);
        Panasonic.getPanasonic();
        listWithElements = forPanasonic.getNamesOfElements();
        List<String> listWithTitles = forPanasonic.getTextsOfElements(listWithElements);
        for(String li : listWithTitles) {
            Assert.assertTrue(li.contains("Panasonic"));
        }
    }

    @Test
    public void TestCountOfElements() throws Exception {
        ProducerPage Panasonic = new ProducerPage(driver);
        BlockWithGoods forPanasonic = new BlockWithGoods(driver);
        int resultCountOfElements = Panasonic.getPanasonicNumber();
        Panasonic.getPanasonic();
        listWithElements = forPanasonic.getNamesOfElements();
        Assert.assertTrue(listWithElements.size() == resultCountOfElements);
    }

    @Test
    public void TestCompateCountWithTitle() {
        ProducerPage Panasonic = new ProducerPage(driver);
        BlockWithGoods forPanasonic = new BlockWithGoods(driver);
        Panasonic.getPanasonic();
        int resultCountOfElements = forPanasonic.getNumberOfCountElements();
        listWithElements = forPanasonic.getNamesOfElements();
        Assert.assertTrue(listWithElements.size() == resultCountOfElements);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
