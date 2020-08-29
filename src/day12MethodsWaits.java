import Utils.Selenium_utils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.SQLOutput;

public class day12MethodsWaits {
    public static void main(String[] args) {

    WebDriver driver = Selenium_utils.initializeDriver();

    driver.get("http://automation.techleadacademy.io/#/synchronization");

    WebElement element1= driver.findElement(By.id("input-text"));
//    Selenium_utils.waitForVisibility(element1);
//    Selenium_utils.highlightElement(element1,driver);
//    element1.sendKeys("Alex");
        Selenium_utils.sendKeys(driver,element1,  "Alex");


    WebElement element2 =driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
//    Selenium_utils.waitForClickability(element2);
//    Selenium_utils.highlightElement(element2,driver);
//    element2.click();
        Selenium_utils.click(driver,element2);


    WebElement element3 = driver.findElement(By.id("text-display"));
    System.out.println(Selenium_utils.waitForVisibilityByText(element3, "Alex", driver).getText());

    WebElement element4 = driver.findElement(By.xpath("//div[@class='row']"));
    System.out.println(Selenium_utils.getText(driver,element4 ));


}

}