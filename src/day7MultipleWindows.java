import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class day7MultipleWindows {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//right placement

        driver.get("http://automation.techleadacademy.io/#/multiplewindow");

        String mainWindow = driver.getWindowHandle();
        System.out.println(mainWindow);

        driver.findElement(By.linkText("Launch TLA")).click();
        System.out.println(driver.getTitle());//driver stayed at the same page and didnt switch even though new window was opened and is displayed now as active
        driver.findElement(By.linkText("Launch Google")).click();
        driver.findElement(By.linkText("Launch Facebook")).click();

        Set <String> set= driver.getWindowHandles();


        for (String e: set){
            if(!e.equals(mainWindow)){
            driver.switchTo().window(e);
            System.out.println(driver.getTitle());
        }}
            Iterator<String> it = set.iterator();
        while (it.hasNext()){
            if(!it.next().equals(mainWindow)){
                driver.switchTo().window(it.next());
                Thread.sleep(2000);
                System.out.println(driver.getTitle());
                System.out.println(it.next());
            }
        }


    }
}
