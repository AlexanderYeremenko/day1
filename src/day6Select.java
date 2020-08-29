import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import javax.crypto.spec.PSource;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class day6Select {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//it should be like here

        driver.get("http://automation.techleadacademy.io/#/selectclass");

        WebElement element = driver.findElement(By.name("select1"));
        Select select = new Select(element);
        select.selectByVisibleText("Ten");
        select.selectByIndex(1);
        select.selectByValue("One");

        List<WebElement> list = select.getOptions();
        list.forEach(value->System.out.println(value.getText()));

        WebElement element1 = driver.findElement(By.name("cars"));
        Select select1 = new Select(element1);
        System.out.println(select1.isMultiple());
        select1.selectByValue("SDET");
        select1.selectByIndex(3);
        select1.selectByVisibleText("Devops");

        select1.getAllSelectedOptions().forEach(value-> System.out.println(value.getText()));
        System.out.println(select1.getFirstSelectedOption().getText());

        select1.deselectByIndex(3);
        select1.deselectAll();

        WebElement element2 = driver.findElement(By.xpath("//div[@class='dropdown-heading-value']"));
        System.out.println(element2.getText());

        element2.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[contains(text(),'Grapes')]")).click();
        System.out.println(element2.getText());
        element2.click();

        WebElement element3 = driver.findElement(By.xpath("//button[@type='button']"));
        System.out.println(element3.getText());
        element3.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[starts-with(text(),'Run')]")).click();
        System.out.println(element3.getText());

    }
}
