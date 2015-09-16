package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Оксана on 28.08.2015.
 */
public class First {
    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://docs.seleniumhq.org/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void test() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.cssSelector("#menu_download>a")).click();

        try {
            Assert.assertTrue(driver.findElement(By.xpath("//div[@id='mainContent']/h3[2]")).getText().contains("Server"));
        } catch (Exception e) {
            System.out.println("Word doesn't consist");
        }

        try {
            Assert.assertTrue(driver.findElement(By.xpath("//div[@id='mainContent']/table[1]")).getText().contains("Ruby"));
            System.out.println("word exists");
        } catch (Exception e) {
            System.out.println("word doesn't exist");
        }

        try {
            Assert.assertFalse(driver.findElement(By.xpath("//div[@id='mainContent']/table[2]")).getText().contains("Ruby"));
            System.out.println("word doesn't exist");
        } catch (Exception e) {
            System.out.println("word exists");
        }
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

}
