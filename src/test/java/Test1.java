import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Test1{

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize(); // Maximize cửa sổ trình duyệt

    }

    @Test
    public void testCase1() {
        ShareFile sf = new ShareFile(driver);
        sf.open_Url("https://www.utest.com/");
        sf.findXpath("//button[@id='onetrust-accept-btn-handler']").click();
        sf.findXpath("//a[@class='unauthenticated-nav-bar-new__sign-up']").click();
        sf.findXpath("//form[@name='userForm']//button[@class='btn btn-blue']").click();

        //Step 3: Verify warning message display correctly
        String firstname_message = sf.findByID("firstNameError").getText();
        assertTrue("firstname error not found!", firstname_message.contains("First name is required"));

        String lastname_message = sf.findByID("lastNameError").getText();
        assertTrue("lastnamerror not found!", lastname_message.contains("Last name is required"));

        String Emailerror_message = sf.findByID("emailError").getText();
        assertTrue("email error not found!", Emailerror_message.contains("Enter valid email"));

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
