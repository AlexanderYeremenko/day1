import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class day9Tables {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);//right placement

        driver.get("http://automation.techleadacademy.io/#/tables");
        WebElement table = driver.findElement(By.xpath("//table[@class='table table-striped']"));
        List<WebElement> rows = table.findElements(By.xpath("//tr"));
        rows.forEach(r-> System.out.println(r.getText()));

        for(int i = 1; i<rows.size(); i++){
            System.out.print(driver.findElement(By.xpath("//table[@class='table table-striped']//tr["+i+"]//td[1]")).getText()+"---");
            System.out.println(driver.findElement(By.xpath("//table[@class='table table-striped']//tr["+i+"]//td[6]")).getText());
        }
//        for (WebElement e: rows){
//            List<WebElement> list = e.findElements(By.xpath("//td"))
//            System.out.println(list.get(1).getText());



        }
        }



