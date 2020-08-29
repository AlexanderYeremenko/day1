import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class day11Waits {

        public static void main(String[] args)  {
            System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//right placement
            WebDriverWait wait = new WebDriverWait(driver,16);

            driver.get("http://automation.techleadacademy.io/#/synchronization");

//            WebElement ttt= driver.findElement(By.id("input-text"));
//            ttt.sendKeys("Alex");
//            driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
//            WebElement lll= driver.findElement(By.id("text-display"));
//            wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("text-display")),"Alex"));
//            System.out.println(lll.getText());
//
//            driver.findElement(By.xpath("//button[@class='btn btn-warning']")).click();
//            wait.until(ExpectedConditions.alertIsPresent());
//            Alert alert = driver.switchTo().alert();
//            System.out.println(alert.getText());
//            alert.accept();

            driver.findElement(By.xpath("//input[@class='form-control m-2']")).sendKeys("Toronto");
            driver.findElement(By.xpath("//i[@class='fas fa-search']")).click();
            WebElement kkk =driver.findElement(By.id("city"));
            wait.until(ExpectedConditions.visibilityOf(kkk));
            System.out.println(driver.findElement(By.id("weather-dashboard")).getText());








        }
}
