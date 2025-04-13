import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
        driver.findElement(By.xpath("/html/body/ui-view/unauthenticated-container/div/div/unauthenticated-header-new/header/div/div[2]/ul/li[2]/a")).click();
        driver.findElement(By.xpath("#regs_container > div > div:nth-child(2) > div > div.ui-view > div > form > div.form-group.col-xs-12.text-right > button")).click();


    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
