import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class day10MapListValue {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);//right placement

        driver.get("http://automation.techleadacademy.io/#/iframes");
        driver.switchTo().frame("parent-iframe");
        driver.switchTo().frame("budget-tracker");

        List <WebElement> key = driver.findElements(By.xpath("//tbody[@id='tbody']//td[1]"));
        List <WebElement> value = driver.findElements(By.xpath("//tbody[@id='tbody']//td[2]"));

        Map<String, String> map = new HashMap<>();

        for(int i =0; i<key.size(); i++){
            map.put(key.get(i).getText(), value.get(i).getText());
        }


        driver.switchTo().defaultContent();
        driver.switchTo().frame("note");
        driver.findElement(By.xpath("//input[@class='note-title']")).sendKeys("Alex");

        for(String str: map.keySet()) {
            driver.findElement(By.xpath("//textarea[@class='note-textarea']")).sendKeys(map.get(str) + "--" + str+Keys.ENTER);
        }

        driver.findElement(By.xpath("//div[@class='icons']//i")).click();

        driver.findElement(By.xpath("//*[text()='Alex']")).click();
        System.out.println(driver.findElement(By.xpath("//textarea[@class='note-textarea']")).getAttribute("value"));
        System.out.println(driver.findElement(By.xpath("//input[@class='note-title']")).getAttribute("value").equals("Alex"));
}}

//classwork was like that:
// driver.get("http://automation.techleadacademy.io/#/iframes");
//        driver.switchTo().frame("parent-iframe");
//        driver.switchTo().frame("budget-tracker");
//        List<WebElement> tNames = driver.findElements(By.xpath("//tbody[@id='tbody']/tr/td[1]"));
//        List<WebElement> tPrice = driver.findElements(By.xpath("//tbody[@id='tbody']/tr/td[2]"));
//        Map<String, String> map = new HashMap<>();
//        for(int i = 0; i < tNames.size(); i++){
//        map.put(tNames.get(i).getText(), tPrice.get(i).getText());
//        }driver.switchTo().defaultContent();
//        driver.switchTo().frame("note");
//        WebElement noteTitle = driver.findElement(By.xpath("//input[@class='note-title']"));
//        WebElement textArea = driver.findElement(By.xpath("//textarea[@class='note-textarea']"));
//        WebElement saveBtn = driver.findElement(By.xpath("//i[@class='fas fa-save text-light save-note']"));
//        noteTitle.sendKeys("TLA");for (String name: map.keySet()){
//        textArea.sendKeys(name + " - " + map.get(name) + "\n");
//        }saveBtn.click();
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//li/span[text()='TLA']")).click();
//        System.out.println(driver.findElement(By.xpath("//input[@class='note-title']")).getAttribute("value") + "\n");
//        System.out.println(driver.findElement(By.xpath("//textarea[@class='note-textarea']")).getAttribute("value"));driver.findElement(By.xpath("//li/span[text()='TLA']/following-sibling::i")).click();