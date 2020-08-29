package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Selenium_utils {

    public static WebDriver initializeDriver() {
        System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }

    public static WebElement waitForVisibilityByText(WebElement element, String text, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("text-display")), "Alex"));
        return element;
    }

    public static WebElement waitForVisibility(WebDriver driver,WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public static WebElement waitForClickability(WebDriver driver,WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    public static WebElement highlightElement(WebElement element, WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        boolean highlight = false;
        for (int i = 0; i < 5; i++) {
            js.executeScript("arguments[0].scrollIntoView(true);", element);
            if (!highlight) {
                js.executeScript("arguments[0].style.backgroundColor='yellow'", element);
                highlight = true;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                js.executeScript("arguments[0].style.backgroundColor='red'", element);
                highlight = false;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return element;
    }
public static void click(WebDriver driver, WebElement element){
        waitForClickability(driver,element);
        highlightElement(element, driver);
        element.click();
}
    public static String getText(WebDriver driver, WebElement element){
        waitForVisibility(driver,element);
        highlightElement(element, driver);
        return element.getText();
}
    public static void sendKeys(WebDriver driver, WebElement element, String text) {
        waitForVisibility(driver,element);
        highlightElement(element, driver);
        element.sendKeys(text);
    }}
