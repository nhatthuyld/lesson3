import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class Step2Object {
    WebDriver driver;
    ShareFile sf;

    private static String stepTitle2ID = "//span[normalize-space()='Step 2:']";
    private static String cityID = "//input[@type='search']";
    private static String citySelectorID = "#cdk-overlay-0 div div";
    private static String zipID = "zip";
    private static String countryID = "countryId";
    private static String nextBtnID = "button[class='btn btn-blue'] i[class='material-icons']";


    public Step2Object(WebDriver driver) {
        this.driver = driver;
        sf = new ShareFile(driver);

    }

    public void verifyStep2() {

        String title_step2 = sf.findXpath(stepTitle2ID).getText();
        assertTrue("Step 2 not found", title_step2.contains("Step 2:"));
    }

    public void fillCity() {

        sf.findXpath(cityID).sendKeys("ho chi minh");
        // 3. Wait briefly if needed (or use WebDriverWait)
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }

        // 4. Get options and click the one you want
        List<WebElement> countryOptions = driver.findElements(By.cssSelector(citySelectorID));
        for (WebElement option : countryOptions) {
            if (option.getText().contains("Ho Chi Minh")) {
                option.click();
                break;
            }
        }
    }

    public void fillZip() {

        sf.findByID(zipID).sendKeys("70000");

    }

    public void fillCountry() {

        WebElement country_Select = sf.findByID(countryID);
        Select Country_option = new Select(country_Select);
        Country_option.selectByVisibleText("Vietnam");

    }

    public  void clickNext(){

        sf.findCSSSelector(nextBtnID).click();
    }
}
