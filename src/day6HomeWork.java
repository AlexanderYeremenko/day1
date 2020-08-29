import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Collections;
import java.util.List;

public class day6HomeWork {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        System.out.println(driver.findElement(By.className("product_sort_container")).getText());
        Select select = new Select(driver.findElement(By.className("product_sort_container")));
        select.selectByValue("lohi");

        List<WebElement> element = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        element.size();
//        Collections.sort(element);

    }
}
