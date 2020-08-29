import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class day6ClassWork {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","E:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);//it should be like here

        driver.get("http://automationpractice.com");
        driver.findElement(By.linkText("Contact us")).click();

        WebElement element = driver.findElement(By.id("id_contact"));
        Select select = new Select(element);
        select.selectByIndex(1);
//        simpler
//        Select select = new Select(driver.findElement(By.id("id_contact")));
//        select.selectByVisibleText("Webmaster");


        driver.findElement(By.id("email")).sendKeys("mail@mail.com");
        driver.findElement(By.id("id_order")).sendKeys("reference");
        driver.findElement(By.id("message")).sendKeys("message");

        driver.findElement(By.id("submitMessage")).click();

        System.out.println(driver.findElement(By.xpath("//p[@class='alert alert-success']")).getText());






    }
}
