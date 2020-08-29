import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class day1 {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver","E:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.ebay.com");

        Thread.sleep(2000);//pause and throws exception

        System.out.println(driver.findElement(By.className("gf-legal")).getText());
        System.out.println(driver.getTitle());
        System.out.println(driver.getTitle().equalsIgnoreCase("Amzon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more"));

        driver.navigate().to("http://ebay.com");
//        driver.navigate().back();
//        driver.navigate().forward();

        System.out.println(driver.getCurrentUrl());
        driver.close();

    }
}
