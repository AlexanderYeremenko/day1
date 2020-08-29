import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class day9Actions {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);//right placement

        driver.get("http://automation.techleadacademy.io/#/actionclass");

        Actions action = new Actions(driver);

        WebElement hover = driver.findElement(By.xpath("//button[@class='btn btn-success btn-lg m-2']"));
        action.moveToElement(hover).perform();
        Thread.sleep(2000);

        WebElement doubleclick = driver.findElement(By.xpath("//button[@class='btn btn-warning m-2 btn-lg']"));
        action.doubleClick(doubleclick).perform();
        Thread.sleep(2000);

        WebElement rightclick = driver.findElement(By.xpath("//button[@class='btn btn-info btn-lg m-2']"));
        action.contextClick(rightclick).perform();

        //chainning
        //action.moveToElement(element).click().sendKeys("TLA").perform;

        //getting tooltip
        driver.get("https://youtube.com");
        System.out.println(driver.findElement(By.xpath("//a[@id='logo']")).getAttribute("title"));

        driver.get("https://etsy.com");
        WebElement cart = driver.findElement(By.xpath("//*[@class='wt-tooltip wt-tooltip--bottom-left wt-tooltip--disabled-touch']"));
        WebElement tooltip = driver.findElement(By.xpath("//span[@role='tooltip']"));
        System.out.println("Pre hover: " + tooltip.getText());
        action.moveToElement(cart).perform();
        System.out.println("Post hover: " + tooltip.getText());

        //select copy paste
        driver.get("http://automation.techleadacademy.io/#/inputs");
        WebElement element = driver.findElement(By.id("message"));
        element.sendKeys("TLA Automation");
        Thread.sleep(2000);
        action.keyDown(element, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        Thread.sleep(2000);
        action.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
        Thread.sleep(2000);
        WebElement target = driver.findElement(By.id("a"));
        action.keyDown(target, Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();

        //copy_paste(element, target, driver); method

        driver.close();
    }

        static void copy_paste(WebElement source, WebElement target, WebDriver driver){
        Actions action = new Actions(driver);
        action.keyDown(source, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        action.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
        action.keyDown(target, Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();





    }
}