import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;
import static org.testng.AssertJUnit.assertTrue;

public class Test5 extends TestcaseBase {

    @Test
    public void testCase5() throws InterruptedException {
        ShareFile sf = new ShareFile(driver);
        sf.open_Url("https://www.utest.com/");
        sf.findXpath("//button[@id='onetrust-accept-btn-handler']").click();
        sf.findXpath("//a[@class='unauthenticated-nav-bar-new__sign-up']").click();

        // sf.findByID("firstname").sendKeys("nguyen nhat");
        WebElement namebtn = sf.findByID("firstName");
        namebtn.sendKeys("nguyen nhat");
        sf.findByID("lastName").sendKeys("tran");
        sf.findByID("email").sendKeys("thuy@gmail.com");
        //Choose birth Month
        WebElement select_birthMonth = sf.findByID("birthMonth");
        Select Select_BM = new Select(select_birthMonth);
        Select_BM.selectByIndex(1);

        //Choose birth Day
        WebElement select_birthDay = sf.findByID("birthDay");
        Select Select_BD= new Select(select_birthDay);
        Select_BD.selectByVisibleText("11");

        //Choose birth year
        WebElement select_birthYear = sf.findByID("birthYear");
        Select Select_BY= new Select(select_birthYear);
        Select_BY.selectByValue("1993");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, -2000);"); // Scroll up by 500 pixels
        Thread.sleep(Duration.ofSeconds(1));

        //CLick button next
        sf.findXpath("//span[normalize-space()='Next: Location']").click();

        //verify title step 2
        // Thread.sleep(Duration.ofMillis(300));
        String title_step2 = sf.findXpath("//span[normalize-space()='Step 2:']").getText();
        assertTrue("Step 2 not found", title_step2.contains("Step 2:"));

        //Type city
        sf.findXpath("//input[@type='search']").sendKeys("ho chi minh");

        // 3. Wait briefly if needed (or use WebDriverWait)
        try { Thread.sleep(2000); } catch (InterruptedException e) {}

        // 4. Get options and click the one you want
        List<WebElement> options = driver.findElements(By.cssSelector("#cdk-overlay-0 div div")); // adjust selector
        for (WebElement option : options) {
            if (option.getText().contains("Ho Chi Minh")) {
                option.click();
                break;
            }
            else System.out.println("No result matching");
        }


        Thread.sleep(Duration.ofSeconds(1));
        //input zip
        sf.findByID("zip").sendKeys("70000");

        // Select country
        WebElement country_Select = sf.findByID("countryId");
        Select Country_option= new Select(country_Select);
        Country_option.selectByVisibleText("Vietnam");

        //Click next
        sf.findCSSSelector("button[class='btn btn-blue'] i[class='material-icons']").click();
        Thread.sleep(Duration.ofMillis(1000));

        //Clear your computer
        sf.findCSSSelector("button[aria-label='Clear Computer OS selection'] i[class='material-icons']").click();
        //Check textbox your computer is cleared
        WebElement inputBox = sf.findCSSSelector("div[name='osId'] span[aria-label='Select OS']");
        String text = inputBox.getText();
        if (text.equalsIgnoreCase("Select OS")) {
            System.out.println("Textbox is clear.");
        } else {
            System.out.println("Textbox is NOT clear. It contains: " + text);
        }



    }

}
