import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class day11ClassWork {
    public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);//right placement



    driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
    driver.findElement(By.xpath("//span[contains(text(),'M')]")).click();
    List<WebElement> list1 = driver.findElements(By.xpath("//div[@data-sku='51498472915966370']"));
    if(list1.size()==1){
        System.out.println("Size M is 1 item");}
    else{
        System.out.println("Size is not 1");}
        driver.findElement(By.xpath("//span[contains(text(),'M')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'XXL')]")).click();
        Thread.sleep(3000);

        List<WebElement>name = driver.findElements(By.xpath("//p[@class='shelf-item__title']"));
        List<WebElement>price = driver.findElements(By.xpath("//div[@class='val']"));

        for(int i=0; i<name.size(); i++){
        System.out.print(name.get(i).getText()+"-");
        System.out.println(price.get(i).getText());

        }
        List<WebElement> buybbtn= driver.findElements(By.xpath("//div[@class='shelf-item__buy-btn']"));
        for(int i=0; i<buybbtn.size(); i++){
            driver.findElement(By.xpath("//div[@class='float-cart__close-btn']")).click();
            buybbtn.get(i).click();
            Thread.sleep(500);
//           driver.findElement(By.xpath("//div[@class='float-cart__close-btn']")).click();
            }

        List<WebElement> cart = driver.findElements(By.xpath("//p[@class='title']"));
        for(int i=0; i<cart.size(); i++){
            System.out.print(cart.get(i).getText()+"--");
            System.out.println(name.get(i).getText());
            System.out.println(cart.get(i).getText().equals(name.get(i).getText()));
                    }
         Select select= new Select(driver.findElement(By.xpath("//div[@class='sort']/select")));
        select.selectByValue("lowestprice");

        List<WebElement> prices = driver.findElements(By.xpath("//div[@class='shelf-container  ']//div[@class='val']"));

        for(int i=0; i<prices.size(); i++){
            System.out.println(prices.get(i).getText());
             }







    }
}
