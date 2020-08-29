import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class day10JS {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);//right placement

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        driver.get("https://amazon.com");
        WebElement element = driver.findElement(By.xpath("//*[text()='Amazon Drive']"));

        //print tile of the page
        System.out.println(javascriptExecutor.executeScript("return document.title"));

        //move to element to be visible on the page
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);

        //set element border color
        javascriptExecutor.executeScript("arguments[0].setAttribute('style','border: solid 2px red');", element);

        //set background to yellow
        javascriptExecutor.executeScript("arguments[0].style.backgroundColor='yellow'", element);

//        static void clickElement(WebElement element, WebDriver driver){
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            js.executeScript("arguments[0].style.backgroundColor='yellow'", element);
//            //screenshot method
//            element.click();

//        }static void inputElementandHighlight(WebElement element, WebDriver driver, String input){
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            js.executeScript("arguments[0].style.backgroundColor='yellow'", element);
//            element.sendKeys(input);
    }
}
