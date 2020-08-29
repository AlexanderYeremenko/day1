import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class day9Tables2 {
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
        Thread.sleep(4000);
        driver.switchTo().frame("noncoreIframe");
        driver.switchTo().frame("legacyViewHolder");
        driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[7]/td[1]/a")).click();


        for(int i = 1; i<6; i++){
            System.out.print(driver.findElement(By.xpath("//table[@class='table hover']//tr["+i+"]//td[2]")).getText()+"--");
            System.out.println(driver.findElement(By.xpath("//table[@class='table hover']//tr["+i+"]//td[5]")).getText());
    }
        //another way
            List<WebElement> logs = driver.findElements(By.xpath("//table[@id='resultTable']//tr/td[2]"));
            List<WebElement> dates = driver.findElements(By.xpath("//table[@id='resultTable']//tr/td[5]"));
            for(int j = 0; j< logs.size(); j++){
                System.out.println(logs.get(j).getText()+"--"+ dates.get(j).getText());
            }

        }
    }

