import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class day2HomeWork {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","E:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com");
        System.out.println(driver.findElement(By.id("login_credentials")).getText());
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        List<WebElement> item = driver.findElements(By.className("inventory_item_name"));
        List<WebElement> price = driver.findElements(By.className("inventory_item_price"));
        for(int i=0; i<item.size(); i++) {
            System.out.println(item.get(i).getText() + " price is: " + price.get(i).getText());
        }
        driver.findElement(By.className("inventory_item_name")).click();
            System.out.println(driver.findElement(By.className("inventory_details_name")).getText());
            System.out.println(driver.findElement(By.className("inventory_details_desc")).getText());
            System.out.println(driver.findElement(By.className("inventory_details_price")).getText());

            driver.close();



        }





    }

