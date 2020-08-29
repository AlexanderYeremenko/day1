import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class day3ClassTask {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.automationpractice.com");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        List<WebElement> element= driver.findElements(By.className("sf-with-ul"));
        System.out.println(element.size());
        element.get(3).click();

        System.out.println(driver.findElement(By.linkText("Casual Dresses")).getAttribute("href"));
        System.out.println(driver.findElement(By.linkText("Evening Dresses")).getAttribute("href"));
        System.out.println(driver.findElement(By.linkText("Summer Dresses")).getAttribute("href"));

        driver.findElement(By.linkText("Casual Dresses")).click();
        System.out.println(driver.getTitle().equals("CASUAL DRESSES"));
        driver.navigate().back();
        driver.findElement(By.linkText("Evening Dresses")).click();
        System.out.println(driver.getTitle());
        System.out.println(driver.getTitle().equals("Evening Dresses - My Store"));
        driver.close();



//    System.out.println(element.get(e));}


//        System.out.println(driver.findElement(By));

    }
}
