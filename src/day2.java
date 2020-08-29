import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class day2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","E:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("java");
        Thread.sleep(2000);
        driver.findElement(By.name("btnK")).click();





//        System.out.println(driver.getTitle());
//        driver.findElement(By.name("q")).sendKeys("java latest version");
//        Thread.sleep(3000);
//        driver.findElement(By.name("btnK")).click();
//        System.out.println(driver.getTitle());
//        System.out.println(driver.findElement(By.id("result-stats")).getText());


//
//        List<WebElement> element = driver.findElements(By.className("text"));
//        System.out.println(element.size());
//        System.out.println(element.get(element.size()-1).getText());
//

        }









    }

