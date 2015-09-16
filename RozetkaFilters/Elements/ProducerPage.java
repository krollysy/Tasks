package Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by user on 05.07.2015.
 */
public class ProducerPage {
    private WebDriver driver;
    By acer = By.xpath("//ul[@id='sort_producer']/li[1]/label/a/span/i[1]");
    By apple = By.xpath("//ul[@id='sort_producer']/li[2]/label/a/span/i[1]");
    By asus = By.xpath("//ul[@id='sort_producer']/li[3]/label/a/span/i[1]");
    By dell = By.xpath("//ul[@id='sort_producer']/li[4]/label/a/span/i[1]");
    By fujitsu = By.xpath("//ul[@id='sort_producer']/li[5]/label/a/span/i[1]");
    By gigabyte = By.xpath("//ul[@id='sort_producer']/li[6]/label/a/span/i[1]");
    By hp = By.xpath("//ul[@id='sort_producer']/li[7]/label/a/span/i[1]");
    By lenovo = By.xpath("//ul[@id='sort_producer']/li[8]/label/a/span/i[1]");
    By msi = By.xpath("//ul[@id='sort_producer']/li[9]/label/a/span/i[1]");
    By panasonic = By.xpath("//ul[@id='sort_producer']/li[10]/label/a/span/i[1]");
    By toshiba = By.xpath("//ul[@id='sort_producer']/li[11]/label/a/span/i[1]");
    By numOfAcers = By.xpath("//ul[@id='sort_producer']/li[1]/label/a/span/i[2]");
    By numOfApples = By.xpath("//ul[@id='sort_producer']/li[2]/label/a/span/i[2]");
    By numOfAsus = By.xpath("//ul[@id='sort_producer']/li[3]/label/a/span/i[2]");
    By numOfDell = By.xpath("//ul[@id='sort_producer']/li[4]/label/a/span/i[2]");
    By numOfFujitsu = By.xpath("//ul[@id='sort_producer']/li[5]/label/a/span/i[2]");
    By numOfGigabyte = By.xpath("//ul[@id='sort_producer']/li[6]/label/a/span/i[2]");
    By numOfHp = By.xpath("//ul[@id='sort_producer']/li[7]/label/a/span/i[2]");
    By numOfLenovo = By.xpath("//ul[@id='sort_producer']/li[8]/label/a/span/i[2]");
    By numOfMsi = By.xpath("//ul[@id='sort_producer']/li[9]/label/a/span/i[2]");
    By numOfPanasonic = By.xpath("//ul[@id='sort_producer']/li[10]/label/a/span/i[2]");
    By numOfToshiba = By.xpath("//ul[@id='sort_producer']/li[11]/label/a/span/i[2]");

    public ProducerPage(WebDriver driver) {
        this.driver = driver;
    }

    public void getAcer() {
        driver.findElement(acer).click();
    }

    public void getApple() {
        driver.findElement(apple).click();
    }

    public void getAsus() {
        driver.findElement(asus).click();
    }

    public void getDell() {
        driver.findElement(dell).click();
    }

    public void getFujitsu() {
        driver.findElement(fujitsu).click();
    }

    public void getGigabyte() {
        driver.findElement(gigabyte).click();
    }

    public void getHp() {
        driver.findElement(hp).click();
    }

    public void getLenovo() {
        driver.findElement(lenovo).click();
    }

    public void getMsi() {
        driver.findElement(msi).click();
    }

    public void getPanasonic() {
        driver.findElement(panasonic).click();
    }

    public void getToshiba() {
        driver.findElement(toshiba).click();
    }

    public int getAcersNumber() {
        String num = "";
        char [] arr = driver.findElement(numOfAcers).getText().toCharArray();
        for (char c: arr) {
            if (Character.isDigit(c) == true) {
                num += c;
            }
        }
        return Integer.parseInt(num);
    }

    public int getApplesNumber() {
        String num = "";
        char [] arr = driver.findElement(numOfApples).getText().toCharArray();
        for (char c: arr) {
            if (Character.isDigit(c) == true) {
                num += c;
            }
        }
        return Integer.parseInt(num);
    }

    public int getAsusNumber() {
        String num = "";
        char [] arr = driver.findElement(numOfAsus).getText().toCharArray();
        for (char c: arr) {
            if (Character.isDigit(c) == true) {
                num += c;
            }
        }
        return Integer.parseInt(num);
    }

    public int getDellNumber() {
        String num = "";
        char [] arr = driver.findElement(numOfDell).getText().toCharArray();
        for (char c: arr) {
            if (Character.isDigit(c) == true) {
                num += c;
            }
        }
        return Integer.parseInt(num);
    }

    public int getFujitsuNumber() {
        String num = "";
        char [] arr = driver.findElement(numOfFujitsu).getText().toCharArray();
        for (char c: arr) {
            if (Character.isDigit(c) == true) {
                num += c;
            }
        }
        return Integer.parseInt(num);
    }

    public int getGigabyteNumber() {
        String num = "";
        char [] arr = driver.findElement(numOfGigabyte).getText().toCharArray();
        for (char c: arr) {
            if (Character.isDigit(c) == true) {
                num += c;
            }
        }
        return Integer.parseInt(num);
    }

    public int getHpNumber() {
        String num = "";
        char [] arr = driver.findElement(numOfHp).getText().toCharArray();
        for (char c: arr) {
            if (Character.isDigit(c) == true) {
                num += c;
            }
        }
        return Integer.parseInt(num);
    }

    public int getLenovoNumber() {
        String num = "";
        char [] arr = driver.findElement(numOfLenovo).getText().toCharArray();
        for (char c: arr) {
            if (Character.isDigit(c) == true) {
                num += c;
            }
        }
        return Integer.parseInt(num);
    }

    public int getMsiNumber() {
        String num = "";
        char [] arr = driver.findElement(numOfMsi).getText().toCharArray();
        for (char c: arr) {
            if (Character.isDigit(c) == true) {
                num += c;
            }
        }
        return Integer.parseInt(num);
    }

    public int getPanasonicNumber() {
        String num = "";
        char [] arr = driver.findElement(numOfPanasonic).getText().toCharArray();
        for (char c: arr) {
            if (Character.isDigit(c) == true) {
                num += c;
            }
        }
        return Integer.parseInt(num);
    }

    public int getToshibaNumber() {
        String num = "";
        char [] arr = driver.findElement(numOfToshiba).getText().toCharArray();
        for (char c: arr) {
            if (Character.isDigit(c) == true) {
                num += c;
            }
        }
        return Integer.parseInt(num);
    }
}
