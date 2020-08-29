import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class day8AMC {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);//right placement

        driver.get("https://www.amctheatres.com");
        System.out.println(driver.findElement(By.className("onboarding-tour-modal__body")).getText());
        driver.findElement(By.xpath("//button[@class='Btn Btn--Primary']")).click();
        System.out.println(driver.findElement(By.xpath("//p[@class='tourtip__content']")).getText());
        driver.findElement(By.id("icon_close")).click();

        String mainWindow = driver.getWindowHandle();

        driver.findElement(By.id("icon_facebook")).click();
        driver.findElement(By.id("icon_twitter")).click();
        driver.findElement(By.id("icon_youtube")).click();
        driver.findElement(By.id("icon_instagram")).click();
        driver.findElement(By.id("icon_pinterest")).click();
//        as an option:
//        List<WebElement> buttonsList = driver.findElements(By.xpath("//ul[@class='u-listUnstyled']//i[starts-with(@class,'icon_')]"));
//        for (WebElement e: buttonsList){
//            e.click();

        Set<String> set = driver.getWindowHandles();


        for (String e : set) {
            if (!e.equals(mainWindow)) {
                driver.switchTo().window(e);
                String title = driver.getTitle();
                System.out.println(title);
                switch (title) { //switch (driver.getTitle())
                    case "AMC Theatres - 7 851 фото - Кинотеатр -":
                        System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Нравится')]")).getText());
                        break;
                    case "AMC Theatres (amctheatres) на Pinterest":
                        System.out.println(driver.findElement(By.xpath("//div[@class='Jea zI7 iyn Hsu']")).getText());
                        break;
                    case "AMC Theatres (@AMCTheatres) / Твиттер":
                        System.out.println(driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-18u37iz r-1w6e6rj']")).getText());
                        break;
                    case "AMC Theatres (@amctheatres) • Фото и видео в Instagram":
                        System.out.println(driver.findElement(By.xpath("//ul[@class='k9GMp ']")).getText());
                        break;
                    case "AMC Theatres - YouTube":
                        System.out.println(driver.findElement(By.xpath("//yt-formatted-string[@id='subscriber-count']")).getText());
                        break;
                    default:
                        System.out.println("Different page");
                }}}
//            AMC Theatres - movie times, movie trailers, buy tickets and gift cards.
//
        driver.switchTo().window(mainWindow);

        driver.findElement(By.xpath("//span[@class='Showtimes-label']")).click();
        System.out.println(driver.findElement(By.xpath("//option[@value='amc-hoffman-center-22']")).getText());
        driver.findElement(By.id("icon_close")).click();
        System.out.println(driver.findElement(By.xpath("//div[@class='GenericModal']")).getText());
        driver.findElement(By.xpath("//button[@class='Btn Btn--Secondary']")).click();
        driver.quit();


//          other way to use switch statement with creating methods for it:
//        static void facebookTest(){
//            List<WebElement> list = driver_global.findElements(By.xpath("//span[text()='Community']/parent::div/following-sibling::div"));
//            list.forEach(v -> System.out.println(v.getText()));
//        }    static void  twitterTest(){
//            System.out.println(driver_global.findElement(By.xpath("//div[@class='css-1dbjc4n r-18u37iz r-1w6e6rj']")).getText());
//        }    static void youtubeTest(){
//            System.out.println(driver_global.findElement(By.id("subscriber-count")).getText());
//        }    static void instagramTest(){
//            System.out.println(driver_global.findElement(By.cssSelector("ul.k9GMp")).getText());
//        }    static void pinterestTest(){
//            System.out.println(driver_global.findElement(By.xpath("//div[@class='Jea KO4 zI7 iyn Hsu']")).getText());
//        }




    }}

