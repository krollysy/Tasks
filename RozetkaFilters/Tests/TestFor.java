package Tests;

import Elements.BlockWithGoods;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by user on 04.07.2015.
 */
public class TestFor {
    WebDriver driver;
    String baseUrl;
    BlockWithGoods a;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        baseUrl = "http://rozetka.com.ua/notebooks/c80004/filter/";
        driver.manage().timeouts().implicitlyWait(30,  TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void test() {
        driver.get(baseUrl);
        a = new BlockWithGoods(driver);
        a.getAllPrices(a.getListOfPrices());
        //driver.findElement(By.xpath("//ul[@id='sort_producer']/li[1]/label/a/span/i[1]")).click();/*By.xpath("//ul[@id='sort_producer']/li[1]/label/a/span/i[1]")*/



        //a.getAllGoods();
        //System.out.println(a.getListSize(a.getAllGoods()));

        /*List<WebElement> list = a.getNamesOfElements();
        System.out.println(list.size());
        List<String> str = a.getTextsOfElements(list);
        System.out.println(str.size());
        for (String l : str) {
            System.out.println(l);
        }*/
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
