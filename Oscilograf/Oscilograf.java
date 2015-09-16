import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by Оксана on 20.05.2015.
 */
public class Oscilograf {
    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://google.com.ua/?gws_rd=ssl";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testOscilograf() throws Exception {
        WebElement element;
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.get(baseUrl);
        int numberOfPage = 1;
        int count = 1;
        element = driver.findElement(By.cssSelector("#lst-ib"));
        element.clear();
        element.sendKeys("осциллограф");
        element.click();

        while (true){
            if (driver.getPageSource().contains("hkjhjkhkj") == true){
                File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(screenshot, new File("C:\\Selenium\\Screenshots\\RightScreenshot\\Screen01.png"));
                System.out.println("Number of page is:" + numberOfPage);
                break;
            } else {
                try{
                    File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                    FileUtils.copyFile(screenshot, new File("C:\\Selenium\\Screenshots\\AllScreenshots\\Screen" + count++ + ".png"));
                driver.findElement(By.xpath("//a[@id='pnnext']/span[2]")).click();
                numberOfPage++;
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='center_col']")));
                } catch (Exception e){
                    System.out.println("This page is not found");
                    break;
                }
            }
        }
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
