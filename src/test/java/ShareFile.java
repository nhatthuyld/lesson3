import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShareFile {
    WebDriver driver;


    public ShareFile(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
   public void open_Url(String url_string)
   {
       driver.get(url_string);
   }
    public WebElement findXpath(String xpath_string) {
        return (driver.findElement(By.xpath(xpath_string)));
    }

    public WebElement findByID(String id_string) {
        return (driver.findElement(By.id(id_string)));
    }



}
