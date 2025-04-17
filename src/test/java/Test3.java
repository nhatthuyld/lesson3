import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Test3 {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
    }

    @Test
    public void testCase3() {
        ShareFile sf = new ShareFile(driver);
        sf.open_Url("https://www.utest.com/");
        sf.findXpath("//button[@id='onetrust-accept-btn-handler']").click();
        sf.findXpath("//a[@class='unauthenticated-nav-bar-new__sign-up']").click();
        sf.findByID("firstname").sendKeys("nguyen nhat");
        sf.findByID("lastname").sendKeys("tran");
        sf.findByID("email").sendKeys("thuy@email.com");
        //Choose birth Month
        WebElement select_birthMonth = sf.findByID("birthMonth");
        Select Select_BM = new Select(select_birthMonth);
        Select_BM.selectByIndex(1);

        //Choose birth Day
        WebElement select_birthDay = sf.findByID("birthDay");
        Select Select_BD= new Select(select_birthDay);
        Select_BD.selectByVisibleText("11");

        //Choose birth Day
        WebElement select_birthYear = sf.findByID("birthYear");
        Select Select_BY= new Select(select_birthYear);
        Select_BY.selectByValue("1993");

        //CLick button next
        sf.findXpath("//span[normalize-space()='Next: Location']").click();

        //verify title step 2
        String title_step2 = sf.findXpath("//span[normalize-space()='Step 2:']").getText();
        assertTrue("Step 2 not found", title_step2.contains("Step 2:"));







    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
