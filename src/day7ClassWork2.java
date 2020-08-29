import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import sun.net.www.content.text.plain;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class day7ClassWork2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//right placement

        driver.get("https://orbitz.com");
        driver.findElement(By.className("itemHeading")).click();
        driver.findElement(By.xpath("//img[contains(@src,'Insider')]")).click();


        driver.findElement(By.xpath("//h5[@class='card-figure-heading  theme ']/following::a")).click();
        Thread.sleep(3000);
        System.out.println(driver.findElement(By.xpath("//h2[@class='mod-onboarding-title no-outline']")).getText());
        System.out.println(driver.findElement(By.xpath("//p[@class='mod-onboarding-sign-up-additional-info remove-margin']")).getText());
        driver.findElement(By.xpath("//span[@class='icon icon-close']")).click();





    }
}
