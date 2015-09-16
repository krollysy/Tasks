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
public class TestsForLenovo {
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
        ProducerPage Lenovo;
        BlockWithGoods forLenovo;
        Lenovo = new ProducerPage(driver);
        forLenovo = new BlockWithGoods(driver);
        Lenovo.getLenovo();
        String pageTitle = forLenovo.getPageTitle();
        System.out.println(pageTitle);
        Wait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".c-cols-inner-l>h1")));
        Assert.assertTrue(pageTitle.contains("Lenovo"));
    }

    @Test
    public void TestContainsElement() throws Exception{
        ProducerPage Lenovo = new ProducerPage(driver);
        BlockWithGoods forLenovo = new BlockWithGoods(driver);
        Lenovo.getLenovo();
        listWithElements = forLenovo.getNamesOfElements();
        List<String> listWithTitles = forLenovo.getTextsOfElements(listWithElements);
        for(String li : listWithTitles) {
            Assert.assertTrue(li.contains("Lenovo"));
        }
    }

    @Test
    public void TestCountOfElements() throws Exception {
        ProducerPage Lenovo = new ProducerPage(driver);
        BlockWithGoods forLenovo = new BlockWithGoods(driver);
        int resultCountOfElements = Lenovo.getLenovoNumber();
        Lenovo.getLenovo();
        listWithElements = forLenovo.getNamesOfElements();
        Assert.assertTrue(listWithElements.size() == resultCountOfElements);
    }

    @Test
    public void TestCompateCountWithTitle() {
        ProducerPage Lenovo = new ProducerPage(driver);
        BlockWithGoods forLenovo = new BlockWithGoods(driver);
        Lenovo.getLenovo();
        int resultCountOfElements = forLenovo.getNumberOfCountElements();
        listWithElements = forLenovo.getNamesOfElements();
        Assert.assertTrue(listWithElements.size() == resultCountOfElements);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
