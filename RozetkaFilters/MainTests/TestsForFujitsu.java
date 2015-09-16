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
public class TestsForFujitsu {
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
        ProducerPage Fujitsu;
        BlockWithGoods forFujitsu;
        Fujitsu = new ProducerPage(driver);
        forFujitsu = new BlockWithGoods(driver);
        Fujitsu.getFujitsu();
        String pageTitle = forFujitsu.getPageTitle();
        System.out.println(pageTitle);
        Wait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".c-cols-inner-l>h1")));
        Assert.assertTrue(pageTitle.contains("Fujitsu"));
    }

    @Test
    public void TestContainsElement() throws Exception{
        ProducerPage Fujitsu = new ProducerPage(driver);
        BlockWithGoods forFujitsu = new BlockWithGoods(driver);
        Fujitsu.getFujitsu();
        listWithElements = forFujitsu.getNamesOfElements();
        List<String> listWithTitles = forFujitsu.getTextsOfElements(listWithElements);
        for(String li : listWithTitles) {
            Assert.assertTrue(li.contains("Fujitsu"));
        }
    }

    @Test
    public void TestCountOfElements() throws Exception {
        ProducerPage Fujitsu = new ProducerPage(driver);
        BlockWithGoods forFujitsu = new BlockWithGoods(driver);
        int resultCountOfElements = Fujitsu.getFujitsuNumber();
        Fujitsu.getFujitsu();
        listWithElements = forFujitsu.getNamesOfElements();
        Assert.assertTrue(listWithElements.size() == resultCountOfElements);
    }

    @Test
    public void TestCompateCountWithTitle() {
        ProducerPage Fujitsu = new ProducerPage(driver);
        BlockWithGoods forFujitsu = new BlockWithGoods(driver);
        Fujitsu.getFujitsu();
        int resultCountOfElements = forFujitsu.getNumberOfCountElements();
        listWithElements = forFujitsu.getNamesOfElements();
        Assert.assertTrue(listWithElements.size() == resultCountOfElements);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
