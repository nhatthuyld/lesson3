import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestcaseBase {
    WebDriver driver;
    private static String url = "https://www.utest.com";

    @BeforeMethod
    public void setup() {

        driver = new ChromeDriver();
        driver.manage().window().maximize(); // Maximize cửa sổ trình duyệt

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public void openURL(){
        driver.get(url);
    }
}
