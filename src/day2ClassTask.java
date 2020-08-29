import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class day2ClassTask {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","E:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver();

        driver.get("http://automation.techleadacademy.io");
        System.out.println(driver.findElement(By.className("header-text")).getText());


        List<WebElement> element = driver.findElements(By.className("link"));
        for(WebElement e: element){
            System.out.println(e.getText()+ " - " +e.getAttribute("href"));
        }
        driver.close();

    }
}
