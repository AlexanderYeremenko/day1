import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class day6HomeWork2 {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);//right placement

        driver.get("http:/www.practiceselenium.com");
        System.out.println(driver.findElement(By.xpath("//ul[@class='wsb-navigation-rendered-top-level-menu ']")).getText());
        driver.findElement(By.linkText("Our Passion")).click();
        System.out.println(driver.findElement(By.xpath("//div[@id='wsb-element-00000000-0000-0000-0000-000450914902']/child::div")).getText());
        System.out.println(driver.findElement(By.xpath("//div[@id='wsb-element-00000000-0000-0000-0000-000450914920']/child::div")).getText());
        driver.findElement(By.linkText("Menu")).click();
        System.out.println(driver.findElement(By.xpath("//div[@id='wsb-element-00000000-0000-0000-0000-000453230000']")).getText());
        System.out.println(driver.findElement(By.xpath("//div[@id='wsb-element-00000000-0000-0000-0000-000453231735']")).getText());
        System.out.println(driver.findElement(By.xpath("//div[@id='wsb-element-00000000-0000-0000-0000-000453231072']")).getText());
        driver.findElement(By.id("wsb-button-00000000-0000-0000-0000-000451961556")).click();
        driver.findElement(By.id("email")).sendKeys("aerg@aerg.com");
        driver.findElement(By.id("name")).sendKeys("aergaergcom");
        driver.findElement(By.id("address")).sendKeys("aerg22aerg22com");
        driver.findElement(By.id("card_number")).sendKeys("12334");
        driver.findElement(By.id("cardholder_name")).sendKeys("dfgdfjg");
        driver.findElement(By.id("verification_code")).sendKeys("123");
        Select select = new Select(driver.findElement(By.id("card_type")));
        select.selectByVisibleText("Visa");
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();


    }
}
