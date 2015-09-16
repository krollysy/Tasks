import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Оксана on 07.06.2015.
 */


public class TestClass {
        public static void main(String [] args) {
            WebDriver driver = new FirefoxDriver();
            driver.get("https://www.facebook.com/");/*https://vk.com/*/
            LoginPage logg = PageFactory.initElements(driver, LoginPage.class);
            logg.registrationError("lala@mail.ru", "w");
            logg.registrationSuccses("knd19@gmail.com", "jhkjhkj%");/*enter valid login and password for VK or Facebook */
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.close();
        }
}
