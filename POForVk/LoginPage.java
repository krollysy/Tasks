import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Оксана on 07.06.2015.
 */
public class LoginPage extends Page{
    @FindBy(id = "email") /*quick_email*/
    private WebElement email;

    @FindBy(id = "email") /*email*/
    private WebElement seondEmail;

    @FindBy(id = "pass") /*quick_pass*/
    private WebElement pass;

    @FindBy(id = "pass") /*pass*/
    private WebElement secondPass;

    @FindBy(id = "u_0_l") /*quick_login_button*/
    private WebElement button1;

    @FindBy(id = "u_0_2") /* className = "flat_button"*/
    private WebElement button2;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public MainPage registrationSuccses(String userLogin, String userPassword) {
        seondEmail.sendKeys(userLogin);
        secondPass.sendKeys(userPassword);
        button2.click();
        return PageFactory.initElements(driver, MainPage.class);
    }

    public LoginPage registrationError(String userLogin, String userPassword) {
        email.sendKeys(userLogin);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        pass.sendKeys(userPassword);
        button1.click();
        return PageFactory.initElements(driver, LoginPage.class);
    }

}
