import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class day11Orbitz {
        public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);//right placement

        driver.get("https://orbitz.com");
        driver.findElement(By.id("hotel-destination-hp-hotel")).sendKeys("Las Vegas");
        driver.findElement(By.xpath("//a[@data-id=178276]")).click();
        driver.findElement(By.id("hotel-checkin-hp-hotel")).click();
        driver.findElement(By.xpath("//button[@data-year='2020' and @data-month='7' and @data-day='10']")).click();
        driver.findElement(By.id("hotel-checkout-hp-hotel")).click();

        driver.findElement(By.xpath("//button[@data-year='2020' and @data-month='7' and @data-day='24']")).click();////and and and

        Select select = new Select(driver.findElement(By.id("hotel-rooms-hp-hotel")));
        select.selectByVisibleText("2");
        Select select1 = new Select(driver.findElement(By.id("hotel-1-children-hp-hotel")));
        select1.selectByVisibleText("2");
        Select select2 = new Select(driver.findElement(By.id("hotel-1-age-select-1-hp-hotel")));
        select2.selectByVisibleText("2");
        Select select3 = new Select(driver.findElement(By.id("hotel-1-age-select-2-hp-hotel")));
        select3.selectByVisibleText("4");
        driver.findElement(By.xpath("(//button[@data-gcw-change-submit-text='Search'])[2]")).click();////pay attention to paranteces

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//a[@href='/addhotel']")));
        Thread.sleep(3000);
        js.executeScript("window.scrollBy(0,-2000)");
        Thread.sleep(3000);

        List<WebElement> hnames = driver.findElements(By.xpath("//ol[@class='uitk-grid all-x-gutter-three all-y-gutter-three results-list']//h3[@class='is-visually-hidden']"));
//                for (int i = 0; i < hnames.size(); i++) {
//                        System.out.println((i + 1) + "." + hnames.get(i).getText());
//                }
        List<WebElement> rating = driver.findElements(By.xpath("//span[@data-stid='content-hotel-reviews-rating']"));
        List<Double> rrating = new ArrayList<>();
        for (int i = 0; i < rating.size(); i++) {
                rrating.add(Double.valueOf(rating.get(i).getText().substring(0, 3)));
        }

        List<WebElement> price = driver.findElements(By.xpath("//span[@data-stid='content-hotel-lead-price']"));
        List<Integer> pprice = new ArrayList<>();
        for(int i=0; i<price.size(); i++){
           pprice.add(Integer.parseInt(price.get(i).getText().substring(1)));
        }

        List<WebElement> discount =   driver.findElements(By.xpath("//span[@class='uitk-badge-text' and contains(text(),'off')]"));
        List<WebElement> hotelswithdiscounts =  driver.findElements(By.xpath("//span[@class='uitk-badge-text' and contains(text(),'off')]/preceding::h3[@data-stid='content-hotel-title']"));

        Map<String, Double> rrrating = new LinkedHashMap<>();
                for(int i=0; i<rating.size(); i++){
                if(rrating.get(i)>=4.5){
                    rrrating.put(hnames.get(i).getText(),rrating.get(i));
                }}

        Map<String, Integer> ppprice = new LinkedHashMap<>();
                for( int i=0; i<pprice.size(); i++){
                        if(ppprice.get(i)>100){
                                ppprice.put(hnames.get(i).getText(),pprice.get(i));
               }}
//        Map<String, Integer> ddiscount =

                }

        }


