import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class day7Alerts {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","E:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//right placement

        driver.get("http://automation.techleadacademy.io/#/alert");
        driver.findElement(By.cssSelector("button.btn.btn-success.m-2")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();

        driver.findElement(By.cssSelector("button.btn.btn-outline-success")).click();
        Alert alert1=driver.switchTo().alert();
        alert1.sendKeys("10");
        alert1.accept();

        driver.findElement(By.xpath("//button[@class='btn btn-danger m-2']")).click();
        Alert alert2 = driver.switchTo().alert();
        alert2.accept();

        driver.findElement(By.xpath("//button[@class='btn btn-outline-danger']")).click();
        Alert alert3 = driver.switchTo().alert();
        alert3.sendKeys("10");
        alert3.accept();

        driver.findElement(By.xpath("//button[@class='col btn btn-primary btn-lg btn-danger rounded']")).click();
        Alert alert4 = driver.switchTo().alert();
        alert4.sendKeys("15");
        alert4.accept();
        alert4.accept();
        alert4.accept();
        alert4.accept();
        alert4.accept();
        System.out.println(alert4.getText());
        alert4.accept();

        System.out.println(driver.findElement(By.xpath("//div[@id='log']")).getText());



    }
}
