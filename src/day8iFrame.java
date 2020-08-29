import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class day8iFrame {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);//right placement

        driver.get("https://orangehrm-demo-6x.orangehrmlive.com/auth/login");
        driver.findElement(By.xpath("//div[@id='loginAsButtonGroup']")).click();
        driver.findElement(By.xpath("//*[starts-with(text(),'1st')]")).click();

        driver.findElement(By.xpath("//li[@id='menu__Performance']")).click();
        driver.findElement(By.xpath("//li[@id='menu_performanceTracker_EmployeeTrackers']")).click();
        driver.findElement(By.xpath("//a[@id='menu_performanceTracker_viewEmployeePerformanceTrackerList']")).click();
        Thread.sleep(3000);
        driver.switchTo().frame("noncoreIframe");
        driver.switchTo().frame("legacyViewHolder");
        System.out.println(driver.findElement(By.className("head")).getText());

        driver.switchTo().parentFrame();
        driver.findElement(By.xpath("//a[@id='menu_pim_viewMyDetails']")).click();
        Thread.sleep(3000);
        System.out.println(driver.findElement(By.xpath("//li[@class='small-subtitle']")).getText());
        driver.quit();

           }

}