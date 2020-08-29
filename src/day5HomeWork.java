import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class day5HomeWork {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","E:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver();

        driver.get("http://automationpractice.com");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[contains(@href,'drop')]")).click();

        List<String> dresses = new ArrayList<>();
        List<String> dresses2 = new ArrayList<>();


        for(int i =1; i<8; i++) {
            dresses.add(driver.findElement(By.xpath("//*[@id='best-sellers_block_right']/div/ul/li[" + i + "]/div/h5/a")).getText());
            System.out.println(driver.findElement(By.xpath("//*[@id='best-sellers_block_right']/div/ul/li[" + i + "]/div/h5/a")).getText());
            System.out.println(driver.findElement(By.xpath("//*[@id='best-sellers_block_right']/div/ul/li[" + i + "]/div/div/span")).getText());
        }
        driver.findElement(By.xpath("//a[contains(@href,'best-sales')]")).click();

        for(int i =1; i<8; i++) {
            dresses2.add(driver.findElement(By.xpath("//*[@id='center_column']/ul/li[" + i + "]/div/div[2]/h5/a")).getText());
            System.out.println(driver.findElement(By.xpath("//*[@id='center_column']/ul/li[" + i + "]/div/div[2]/h5/a")).getText());
            System.out.println(driver.findElement(By.xpath("//*[@id='center_column']/ul/li[" + i + "]/div/div[2]/div[1]/span[1]")).getText());
        }

        System.out.println("Top Sellers and Best Sellers are the same: "+dresses.equals(dresses2));

        for(int i =1; i<8; i++) {
            driver.findElement(By.xpath("//*[@id='center_column']/ul/li["+i+"]/div/div[2]/div[2]/a[1]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//span[@title='Continue shopping']")).click();
        }
        driver.findElement(By.xpath("//*[@id='header']/div[3]/div/div/div[3]/div/a")).click();

        List<String> dresses3 = new ArrayList<>();
        for(int i = 1; i<8; i++){
        dresses3.add(driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr["+i+"]/td[2]/p/a")).getText());
        }

        System.out.println("Dresses in the cart and Top Sellers are the same: "+dresses3.equals(dresses));

        for(int i = 1; i<8; i++){
            if (dresses3.get(i).contains("Dress"))
                System.out.println("Containg word Dress: " +dresses3.get(i));
        }

        List<WebElement> yellow = driver.findElements(By.xpath("//td[@class='cart_description']"));
        for(int i = 0; i < yellow.size(); i++) {
            if (yellow.get(i).getText().contains("Yellow"))
                System.out.println(yellow.get(i).getText() + "\n");

            }

         driver.close();

    }
}
