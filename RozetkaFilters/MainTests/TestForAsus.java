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
public class TestForAsus {
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
        ProducerPage Asus;
        BlockWithGoods forAsus;
        Asus = new ProducerPage(driver);
        forAsus = new BlockWithGoods(driver);
        Asus.getAsus();
        String pageTitle = forAsus.getPageTitle();
        System.out.println(pageTitle);
        Wait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".c-cols-inner-l>h1")));
        Assert.assertTrue(pageTitle.contains("Asus"));
    }

    @Test
    public void TestContainsElement() throws Exception{
        ProducerPage Asus = new ProducerPage(driver);
        BlockWithGoods forAsus = new BlockWithGoods(driver);
        Asus.getAsus();
        listWithElements = forAsus.getNamesOfElements();
        List<String> listWithTitles = forAsus.getTextsOfElements(listWithElements);
        for(String li : listWithTitles) {
            Assert.assertTrue(li.contains("Asus"));
        }
    }

    @Test
    public void TestCountOfElements() throws Exception {
        ProducerPage Asus = new ProducerPage(driver);
        BlockWithGoods forAsus = new BlockWithGoods(driver);
        int resultCountOfElements = Asus.getAsusNumber();
        Asus.getAsus();
        listWithElements = forAsus.getNamesOfElements();
        Assert.assertTrue(listWithElements.size() == resultCountOfElements);
    }

    @Test
    public void TestCompateCountWithTitle() {
        ProducerPage Asus = new ProducerPage(driver);
        BlockWithGoods forAsus = new BlockWithGoods(driver);
        Asus.getAsus();
        int resultCountOfElements = forAsus.getNumberOfCountElements();
        listWithElements = forAsus.getNamesOfElements();
        Assert.assertTrue(listWithElements.size() == resultCountOfElements);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
