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
    }
   public void open_Url(String url_string)
   {
       driver.get(url_string);
   }
    public void findXpath(String xpath_string)
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath(xpath_string));
    }

    public void clickButton(String xpath_string)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id(xpath_string)));
        loginBtn.click();
    }

}
