import Elements.BlockWithGoods;
import Elements.PricePage;
import Elements.ProducerPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by user on 08.07.2015.
 */
public class TestForPrice {
    WebDriver driver;
    String baseUrl;
    BlockWithGoods forPrice;
    PricePage price;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        baseUrl = "http://rozetka.com.ua/notebooks/c80004/filter/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test
    public void TestForMinPrice() {
        forPrice = new BlockWithGoods(driver);
        price = new PricePage(driver);
       price.typeMinPrice("1200");
        int s = forPrice.getAllPrices(forPrice.getListOfPrices()).get(0);
        try {
            Assert.assertTrue(s == price.getMinPrise());;
        } catch (AssertionError e) {
            System.out.println("Prices don't match");
        }
    }

    @Test
    public void TestForMaxPrice() {
        ProducerPage p = new ProducerPage(driver);
        p.getAcer();
        forPrice = new BlockWithGoods(driver);
        price = new PricePage(driver);
        price.typeMaxPrice("2000000");
        List<Integer> list = forPrice.getAllPrices(forPrice.getListOfPrices());
        int s = list.get(list.size()-1);
        try {
            Assert.assertTrue(s == price.getMaxPrise());;
        } catch (AssertionError e) {
            System.out.println("Prices don't match");
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
