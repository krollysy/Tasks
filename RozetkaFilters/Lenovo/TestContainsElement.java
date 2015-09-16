package Lenovo;

import Elements.BlockWithGoods;
import Elements.ProducerPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by user on 08.07.2015.
 */
public class TestContainsElement {
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
    public void TestContainsElement() throws Exception{
        ProducerPage Lenovo = new ProducerPage(driver);
        BlockWithGoods forLenovo = new BlockWithGoods(driver);
        Lenovo.getLenovo();
        listWithElements = forLenovo.getNamesOfElements();
        List<String> listWithTitles = forLenovo.getTextsOfElements(listWithElements);
        for(String li : listWithTitles) {
            Assert.assertTrue(li.contains("Lenovo "));
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
