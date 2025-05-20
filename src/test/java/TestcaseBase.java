
import org.PageObject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;


public class TestcaseBase {
    WebDriver driver;
    private static String url = "https://www.utest.com";
    SoftAssert softAssert;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void setup() {

        //clean exist image on screenshots fold before run
        BasePage.cleanScreenshotFolder("screenshots");
        ChromeOptions options = new ChromeOptions();
        softAssert = new SoftAssert();
        options.addArguments("--headless=new");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);


    }

    @AfterMethod
    public void tearDown() {

        try {
           // softAssert.assertAll();
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }

    public void openURL() {
        driver.get(url);
    }


}
