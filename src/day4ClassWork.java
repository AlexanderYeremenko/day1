import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;
import java.util.List;

public class day4ClassWork {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://automation.techleadacademy.io/#/");
        driver.findElement(By.linkText("Selectors")).click();
        //Lamborghini
        System.out.println(driver.findElement(By.cssSelector("div#lamborghini>h2")).getText());
        System.out.println(driver.findElement(By.className("vehicle-type")).getText());
        List<WebElement> element = driver.findElements(By.cssSelector("div[class='col col-md-3']>div"));
        for (int i = 1; i < element.size(); i++) {
            System.out.println(element.get(i).getText());
        }
        //Porsche
        System.out.println(driver.findElement(By.cssSelector("div#porsche>h2")).getText());
        System.out.println(driver.findElement(By.cssSelector("div#porsche div")).getText());

        List<WebElement> element2 = driver.findElements(By.cssSelector("div#porsche div u"));
        for(int i=0; i<element2.size(); i++){
            System.out.println(element2.get(i).getText());
            int n=i+1;
            System.out.println(driver.findElement(By.cssSelector("div#porsche div.col:nth-child(n) div:nth-child(3)")).getText());
        }

        //Best Solution;
        //for (int i = 1; i < 5 ;i++){
        //  System.out.println(driver.findElement(By.cssSelector("div#porsche>div>div:nth-child(" + i + ")>div:nth-child(1)")).getText());
        //  System.out.println(driver.findElement(By.cssSelector("div#porsche>div>div:nth-child(" + i + ")>div:nth-child(3)")).getText());}

        //Mercedes


        driver.close();


        System.out.println(driver.findElement(By.xpath("//*[text()='Mercedes B-Class']")).getText());
        System.out.println(driver.findElement(By.xpath("//*[text()='Mercedes CLS_Class']")).getText());
        System.out.println(driver.findElement(By.xpath("//*[text()='Mercedes AMG GT']")).getText());
        System.out.println(driver.findElement(By.xpath("//*[text()='Mercedes GLA-Class']")).getText());
    }
}
