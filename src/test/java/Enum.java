import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Enum {

    public static WebDriver getDriver(BrowserType browserType) {
        WebDriver driver = null;

        switch (browserType) {
            case CHROME:
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case EDGE:
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("Browser not supported");
                break;
        }

        return driver;
    }
    public enum BrowserType {
        CHROME,
        FIREFOX,
        EDGE
    }

    @Test
    public static void OpenBrowser() {
        WebDriver driver = getDriver(BrowserType.CHROME);
        driver.get("https://www.utest.com/");
        driver.quit();
    }
}
