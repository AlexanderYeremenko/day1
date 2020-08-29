import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class day11Weathercom {
    public static void main(String[] args) {

    System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);//right placement

        driver.get("https://weather.com");
        WebDriverWait wait = new WebDriverWait(driver,5);
        WebElement element = driver.findElement(By.xpath("//h2[contains(text(),'Your Privacy')]"));
        wait.until(ExpectedConditions.visibilityOf(element));
        System.out.println(driver.findElement(By.xpath("//div[@class='_-_-components-src-organism-PrivacyDataNotice-PrivacyDataNotice--notice--3kfdf']")).getText());
        driver.findElement(By.xpath("//div[contains(@class,'PrivacyDataNotice')]//*[@name='close']")).click();

        List<WebElement> list = driver.findElements(By.xpath("//ul[contains(@class,'25Y9Z')]//a"));
        for(int i = 0; i<list.size(); i++){
            if(i!=2)
                list.get(i).click();
        }

        String mainWindow = driver.getWindowHandle();
        Set<String> set = driver.getWindowHandles();
        for(String e: set){
            if(!e.equals(mainWindow)){
                driver.switchTo().window(e);
            System.out.println(driver.getTitle());
            driver.close();
            }
        }
driver.switchTo().window(mainWindow);
        driver.findElement(By.xpath("//span[text()='10 Day']")).click();

        List<WebElement> day = driver.findElements(By.xpath("//h3[@data-testid='daypartName']"));
        List<WebElement> htemp = driver.findElements(By.xpath("//span[@data-testid='TemperatureValue' and contains(@class,'highTempValue')]"));
        List<WebElement> ltemp = driver.findElements(By.xpath("//span[@data-testid='TemperatureValue' and contains(@class,'lowTempValue')]"));
        List<WebElement> prog = driver.findElements(By.xpath("//div[@data-testid='wxIcon']"));

        for(int i =0; i<day.size(); i++){
        System.out.println(day.get(i).getText()+" -- "+ htemp.get(i).getText()+"/"+ltemp.get(i).getText()+" -- "+prog.get(i).getText());

        }  }}


//        Kuba:
//        WebDriverWait wait = new WebDriverWait(driver, 15);
//        driver.get("https://weather.com");
//        WebElement popUp = driver.findElement(By.xpath("//h2[text()='Your Privacy']"));
//        wait.until(ExpectedConditions.visibilityOf(popUp));
//        System.out.println(popUp.getText());
//        System.out.println();
//        driver.findElement(By.xpath("//div[contains(@class,'PrivacyDataNotice')]//*[@name='close']")).click();
//        List<WebElement> buttons = driver.findElements(By.xpath("//ul[@locale='en-US' and contains(@class,'socialLinks')]/li"));
//        wait.until(ExpectedConditions.visibilityOf(buttons.get(0)));
//        new Actions(driver).moveToElement(buttons.get(0)).perform();
//        for(int i = 0; i < buttons.size(); i++){
//        if (i != 2){
//        wait.until(ExpectedConditions.elementToBeClickable(buttons.get(i)));
//        buttons.get(i).click();
//        }
//        }String mainID = driver.getWindowHandle();
//        Set<String> set = driver.getWindowHandles();for (String s: set){
//        if (!s.equals(mainID)){
//        driver.switchTo().window(s);
//        System.out.println(driver.getTitle());
//        driver.close();
//        }
//        }driver.switchTo().window(mainID);driver.findElement(By.xpath("//*[text()='10 Day']")).click();
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//details[@data-testid='ExpandedDetailsCard']//*[@data-testid='daypartName']"))));
//        List<WebElement> days = driver.findElements(By.xpath("//details[@data-testid='ExpandedDetailsCard']//*[@data-testid='daypartName']"));
//        List<WebElement> temp = driver.findElements(By.xpath("//details[@data-testid='ExpandedDetailsCard']//*[@data-testid='detailsTemperature']"));
//        List<WebElement> desc = driver.findElements(By.xpath("//details[@data-testid='ExpandedDetailsCard']//*[@data-testid='wxIcon']"));
//        for(int i = 0; i < days.size() ; i++){
//        System.out.println(days.get(i).getText() + " - " + temp.get(i).getText() + " - " + desc.get(i).getText());