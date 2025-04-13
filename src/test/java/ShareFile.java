import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
        driver.findElement(By.xpath(xpath_string));
    }

    public void clickButton(String xpath_string)
    {
        driver.findElement(By.xpath(xpath_string)).click();
    }

}
