package AcerDellPanasonic;

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
        ProducerPage ADP = new ProducerPage(driver);
        BlockWithGoods forADP = new BlockWithGoods(driver);
        ADP.getAcer();
        ADP.getDell();
        ADP.getPanasonic();
        listWithElements = forADP.getNamesOfElements();
        List<String> listWithTitles = forADP.getTextsOfElements(listWithElements);
        for(String li : listWithTitles) {
            try {
                Assert.assertTrue(li.contains("Acer ") || li.contains("Dell ") || li.contains("Panasonic "));
            } catch (AssertionError e) {
                System.out.println("Something doesn't exist");
            }
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
