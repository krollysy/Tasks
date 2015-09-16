package MainTests;

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
 * Created by user on 05.07.2015.
 */
public class TestForApple {
    WebDriver driver;
    String baseUrl;
    List<WebElement> listWithElements;


    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        baseUrl = "http://rozetka.com.ua/notebooks/c80004/filter/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

/*
    @Test
    public void TestWithTitle() throws  Exception{
        ProducerPage Apple;
        BlockWithGoods forApple;
        Apple = new ProducerPage(driver);
        forApple = new BlockWithGoods(driver);
        Apple.getApple();
        String pageTitle = forApple.getPageTitle();
        System.out.println(pageTitle);
        Wait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".c-cols-inner-l>h1")));
        try {
            Assert.assertTrue(forApple.isFiltersAppear());
            Assert.assertTrue(pageTitle.contains("Apple"));
            Assert.assertTrue(pageTitle.contains("Сбросить"));
            Apple.getApple();
            Assert.assertTrue(forApple.isFilterDisappear());
        } catch (AssertionError e) {
            System.out.println("Filter doesn't work");
        }

        try {
            forApple.clickReset();
            Assert.assertTrue(forApple.isFilterDisappear());
        } catch (AssertionError e) {
            System.out.println("Filter doesn't work");
        }

        try {
            Assert.assertTrue(forApple.clickFilterButton());
        } catch (AssertionError e) {
            System.out.println("Filter doesn't work");
        }
    }
*/

    @Test
    public void TestContainsElement() throws Exception{
        ProducerPage Apple = new ProducerPage(driver);
        BlockWithGoods forApple = new BlockWithGoods(driver);
        Apple.getApple();
        listWithElements = forApple.getNamesOfElements();
        List<String> listWithTitles = forApple.getTextsOfElements(listWithElements);
        for(String li : listWithTitles) {
            Assert.assertTrue(li.contains("Apple"));
        }
    }

    @Test
    public void TestCountOfElements() throws Exception {
        ProducerPage Apple = new ProducerPage(driver);
        BlockWithGoods forApple = new BlockWithGoods(driver);
        int resultCountOfElements = Apple.getApplesNumber();
        Apple.getApple();
        listWithElements = forApple.getNamesOfElements();
        Assert.assertTrue(listWithElements.size() == resultCountOfElements);
    }

    @Test
    public void TestCompateCountWithTitle() {
        ProducerPage Apple = new ProducerPage(driver);
        BlockWithGoods forApple = new BlockWithGoods(driver);
        Apple.getApple();
        int resultCountOfElements = forApple.getNumberOfCountElements();
        listWithElements = forApple.getNamesOfElements();
        Assert.assertTrue(listWithElements.size() == resultCountOfElements);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
