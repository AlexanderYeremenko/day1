import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day2WarmUp {


    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://techleadacademy.io");
        System.out.println(driver.getTitle()+" length is: "+ driver.getTitle().length());
        System.out.println(driver.getCurrentUrl()+" length is: "+ driver.getCurrentUrl().length());
        Thread.sleep(1000);

        driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle()+" length is: "+ driver.getTitle().length());
        System.out.println(driver.getCurrentUrl() +" length is: "+ driver.getCurrentUrl().length());
        Thread.sleep(1000);

        driver.get("https://www.theinformation.com");
        System.out.println(driver.getTitle()+" length is: "+ driver.getTitle().length());
        System.out.println(driver.getCurrentUrl()+" length is: "+ driver.getCurrentUrl().length());
        Thread.sleep(1000);

        driver.close();

    }
}
