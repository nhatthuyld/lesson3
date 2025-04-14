import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test1{

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
    }

    @Test
    public void testCase1() {
        ShareFile sf = new ShareFile(driver);
        sf.open_Url("https://www.utest.com/");
        sf.clickButton("//button[text()='Join Now']");


    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
