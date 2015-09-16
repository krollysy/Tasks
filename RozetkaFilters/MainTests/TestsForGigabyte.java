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
public class TestsForGigabyte {
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
        ProducerPage Gigabyte;
        BlockWithGoods forGigabyte;
        Gigabyte = new ProducerPage(driver);
        forGigabyte = new BlockWithGoods(driver);
        Gigabyte.getGigabyte();
        String pageTitle = forGigabyte.getPageTitle();
        System.out.println(pageTitle);
        Wait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".c-cols-inner-l>h1")));
        Assert.assertTrue(pageTitle.contains("Gigabyte"));
    }

    @Test
    public void TestContainsElement() throws Exception{
        ProducerPage Gigabyte = new ProducerPage(driver);
        BlockWithGoods forGigabyte = new BlockWithGoods(driver);
        Gigabyte.getGigabyte();
        listWithElements = forGigabyte.getNamesOfElements();
        List<String> listWithTitles = forGigabyte.getTextsOfElements(listWithElements);
        for(String li : listWithTitles) {
            Assert.assertTrue(li.contains("Gigabyte"));
        }
    }

    @Test
    public void TestCountOfElements() throws Exception {
        ProducerPage Gigabyte = new ProducerPage(driver);
        BlockWithGoods forGigabyte = new BlockWithGoods(driver);
        int resultCountOfElements = Gigabyte.getGigabyteNumber();
        Gigabyte.getGigabyte();
        listWithElements = forGigabyte.getNamesOfElements();
        Assert.assertTrue(listWithElements.size() == resultCountOfElements);
    }

    @Test
    public void TestCompateCountWithTitle() {
        ProducerPage Gigabyte = new ProducerPage(driver);
        BlockWithGoods forGigabyte = new BlockWithGoods(driver);
        Gigabyte.getGigabyte();
        int resultCountOfElements = forGigabyte.getNumberOfCountElements();
        listWithElements = forGigabyte.getNamesOfElements();
        Assert.assertTrue(listWithElements.size() == resultCountOfElements);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
