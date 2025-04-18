import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestcaseBase {
    WebDriver driver;

    @BeforeMethod
    public void setup() {

        driver = new ChromeDriver();
        driver.manage().window().maximize(); // Maximize cửa sổ trình duyệt

    }

    @AfterMethod
    public void tearDown() {
       // driver.quit();
    }
}
