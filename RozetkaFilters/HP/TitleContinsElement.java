package HP;

import Elements.BlockWithGoods;
import Elements.ProducerPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by user on 08.07.2015.
 */
public class TitleContinsElement {
    WebDriver driver;
    String baseUrl;
    ProducerPage Hp;
    BlockWithGoods forHp;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        baseUrl = "http://rozetka.com.ua/notebooks/c80004/filter/";
        driver.manage().timeouts().implicitlyWait(30,  TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test
    public void TestFofTitle() throws  Exception{
        Hp = new ProducerPage(driver);
        forHp = new BlockWithGoods(driver);
        Hp.getHp();
        String pageTitle = forHp.getPageTitle();
        System.out.println(pageTitle);
        Wait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".c-cols-inner-l>h1")));
        try {
            Assert.assertTrue(forHp.isFiltersAppear());
            Assert.assertTrue(pageTitle.contains("HP (Hewlett Packard)"));
            Assert.assertTrue(pageTitle.contains("Сбросить"));
            Hp.getHp();
            Assert.assertTrue(forHp.isFilterDisappear());
        } catch (AssertionError e) {
            System.out.println("Filter doesn't work");
        }
    }

    @Test
    public void TestForReset() throws Exception {
        Hp = new ProducerPage(driver);
        forHp = new BlockWithGoods(driver);
        Hp.getHp();
        try {
            forHp.clickReset();
            Assert.assertTrue(forHp.isFilterDisappear());
        } catch (AssertionError e) {
            System.out.println("Filter doesn't work");
        }
    }

    @Test
    public void TestForFilter() throws Exception {
        Hp = new ProducerPage(driver);
        forHp = new BlockWithGoods(driver);
        Hp.getHp();
        try {
            Assert.assertTrue(forHp.clickFilterButton());
        } catch (AssertionError e) {
            System.out.println("Filter doesn't work");
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
