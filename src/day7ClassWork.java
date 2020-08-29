import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class day7ClassWork {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//right placement

        driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");
        driver.findElement(By.xpath("//button[@id='alertBox']")).click();
        Alert alert =driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();

        driver.findElement(By.xpath("//button[@id='confirmBox']")).click();
        alert.accept();
        System.out.println(driver.findElement(By.xpath("//div[@id='output']")).getText().equalsIgnoreCase("You pressed OK in confirmation popup"));

        driver.findElement(By.xpath("//button[@id='promptBox']")).click();
        alert.sendKeys("Alex");
        alert.accept();
        System.out.println(driver.findElement(By.xpath("//div[@id='output']")).getText().contains("Alex"));

    }
}
