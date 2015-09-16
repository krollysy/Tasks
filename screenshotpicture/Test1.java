import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by Оксана on 03.06.2015.
 */
public class Test1 {
    private WebDriver driver;
    private String baseUrl;
    private WebElement element;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        baseUrl = "http://uk.wikipedia.org";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test
    public void screen() throws Exception{
        driver.findElement(By.xpath("//div[@id='featurded_article']/p/b[1]/a")).click();
        element = driver.findElement(By.xpath("//div[@id='mw-content-text']/table[1]/tbody/tr[3]/td/div/a/img"));
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        BufferedImage fullImg = ImageIO.read(screenshot);
        Point point = element.getLocation();
        int width = element.getSize().getWidth();
        int height = element.getSize().getHeight();
        BufferedImage elementScreenshot= fullImg.getSubimage(point.getX(), point.getY(), width,
                height);
        ImageIO.write(elementScreenshot, "png", screenshot);
        FileUtils.copyFile(screenshot, new File("C:\\Selenium\\Screenshots\\wikiScreen\\screen1.png"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
