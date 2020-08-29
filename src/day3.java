import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class day3 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","E:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver();

        driver.get("http://automation.techleadacademy.io/#/");
//        Thread.sleep(3000);
        driver.findElement(By.linkText("Inputs")).click();
        driver.findElement(By.id("message")).sendKeys("TLA");
        driver.findElement(By.name("button1")).click();
        System.out.println(driver.findElement(By.name("message1")).getText().equalsIgnoreCase("TLA"));

        driver.findElement(By.id("a")).sendKeys("3");
        driver.findElement(By.id("b")).sendKeys("3");
        driver.findElement(By.name("button2")).click();
        System.out.println(driver.findElement(By.name("answer2")).getText().equalsIgnoreCase("7"));


        driver.findElement(By.name("first_name")).sendKeys("Alex");
        driver.findElement(By.name("last_name")).sendKeys("Yer");
        driver.findElement(By.name("email")).sendKeys("@");
        driver.findElement(By.name("phone")).sendKeys("654");
        driver.findElement(By.name("address")).sendKeys("street 25");
        driver.findElement(By.name("city")).sendKeys("london");
        driver.findElement(By.name("zip")).sendKeys("12345");
        driver.findElement(By.name("button3")).click();
        Thread.sleep(3000);

        System.out.println(driver.findElement(By.name("answer3")).getText().equalsIgnoreCase("Thanks for contacting us, we will get back to you shortly."));

        driver.close();



    }
}
