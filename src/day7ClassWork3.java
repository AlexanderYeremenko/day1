import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class day7ClassWork3 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);//right placement

        driver.get("http://automation.techleadacademy.io/#/multiplewindow");
        List<WebElement> list = driver.findElements(By.xpath("//a[contains(@class,'btn btn-lg btn-outline')]"));
        list.forEach(a-> System.out.println(a.getText()));

        driver.findElement(By.xpath("//a[@href='https://www.facebook.com/']")).click();

        String mainWindow = driver.getWindowHandle();
        Set<String> set= driver.getWindowHandles();
        for (String e:set) {
            if (!e.equals(mainWindow)){
                driver.switchTo().window(e);
        }}
        System.out.println(driver.getTitle());
        driver.close();

//              or like that with iterator
//        Iterator<String> iterator = set.iterator();
//        while (iterator.hasNext()){
//            driver.switchTo().window(iterator.next());
//            if (driver.getTitle().equals("Facebook - Log In or Sign Up"))
//                System.out.println(driver.findElement(By.cssSelector("h2._8eso._3ma")).getText());

        driver.switchTo().window(mainWindow);

        driver.findElement(By.xpath("//a[@href='https://www.google.com/']")).click();

        Set<String> set1= driver.getWindowHandles();
        for (String e:set1) {
            if (!e.equals(mainWindow)){
                driver.switchTo().window(e);
        System.out.println(driver.getTitle());}}

        driver.quit();

}}


