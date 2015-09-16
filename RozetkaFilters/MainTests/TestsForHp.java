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
public class TestsForHp {
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
        ProducerPage Hp;
        BlockWithGoods forHp;
        Hp = new ProducerPage(driver);
        forHp = new BlockWithGoods(driver);
        Hp.getHp();
        String pageTitle = forHp.getPageTitle();
        System.out.println(pageTitle);
        Wait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".c-cols-inner-l>h1")));
        Assert.assertTrue(pageTitle.contains("HP (Hewlett Packard)"));
    }

    @Test
    public void TestContainsElement() throws Exception{
        ProducerPage Hp = new ProducerPage(driver);
        BlockWithGoods forHp = new BlockWithGoods(driver);
        Hp.getHp();
        listWithElements = forHp.getNamesOfElements();
        List<String> listWithTitles = forHp.getTextsOfElements(listWithElements);
        for(String li : listWithTitles) {
            Assert.assertTrue(li.contains("HP"));
        }
    }

    @Test
    public void TestCountOfElements() throws Exception {
        ProducerPage Hp = new ProducerPage(driver);
        BlockWithGoods forHp = new BlockWithGoods(driver);
        int resultCountOfElements = Hp.getHpNumber();
        Hp.getHp();
        listWithElements = forHp.getNamesOfElements();
        Assert.assertTrue(listWithElements.size() == resultCountOfElements);
    }

    @Test
    public void TestCompateCountWithTitle() {
        ProducerPage Hp = new ProducerPage(driver);
        BlockWithGoods forHp = new BlockWithGoods(driver);
        Hp.getHp();
        int resultCountOfElements = forHp.getNumberOfCountElements();
        listWithElements = forHp.getNamesOfElements();
        Assert.assertTrue(listWithElements.size() == resultCountOfElements);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
