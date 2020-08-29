import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class day9HomeWork {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);//right placement

        driver.get("http://automation.techleadacademy.io/#/iframes");
        driver.switchTo().frame("parent-iframe");
        driver.switchTo().frame("wiki");


        WebElement element = driver.findElement(By.xpath("//select[@id='searchLanguage']"));
        Select select = new Select(element);
        select.selectByValue("en");
        driver.findElement(By.xpath("//input[@id='searchInput']")).sendKeys("Automation");
        driver.findElement(By.xpath("//i[@class='sprite svg-search-icon']")).click();

        List<WebElement> bulletpoints = driver.findElements(By.xpath("//*[@id='toc']/ul/li/a/span[2]"));
//        bulletpoints.forEach(a-> System.out.println(a.getText()));

        List<String> list = new ArrayList<>();
        for(WebElement e: bulletpoints)
            list.add(e.getText());

        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//a[@id='practice-form']")).click();

        String mainWindow=driver.getWindowHandle();
        Set<String> set = driver.getWindowHandles();
        for(String e: set) {
            if (!e.equals(mainWindow))
                driver.switchTo().window(e);
        }
        //!!! short =part
        Select select1 = new Select(driver.findElement(By.xpath("//select[@id='key-select']")));
//        driver.findElement(By.xpath("//select[@id='key-select']")).click();
        for(int i=1; i<=list.size(); i++) {
            select1.selectByIndex(i);//!!!select By index
            driver.findElement(By.xpath("//input[@id='value-input']")).sendKeys(list.get(i-1));
            //вместо строки выше можно было загнать ее значение в вэбэлемент
            //WebElement input =findElement(By.xpath("//input[@id='value-input']"))
            // и писать короче строку: input.sendKeys(list.get(i-1));
            driver.findElement(By.xpath("//button[@id='enter-btn']")).click();


        System.out.print(driver.findElement(By.xpath(" //*[@id='list-table']/tbody/tr["+i+"]/td[2]")).getText()+"--");
        System.out.println(driver.findElement(By.xpath(" //*[@id='list-table']/tbody/tr["+i+"]/td[3]")).getText());
    }




    }
}
