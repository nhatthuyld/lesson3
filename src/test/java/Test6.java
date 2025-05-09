import org.PageObject.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.time.Duration;
import org.testng.asserts.SoftAssert;


@Listeners(TestListener.class)
public class Test6 extends TestcaseBase {

    private static final Logger logger = LogManager.getLogger(Test6.class);

    @Test
    public void testCase6() throws InterruptedException {
        logger.info("Open page");
        openURL();
        Homepage homepage = new Homepage(driver);
        homepage.JoinNow();

        logger.info("Go to Step 1");
        StepOne step1 = new StepOne(driver);
        step1.fillFirstName("thuy");
        step1.fillLastName("tran");
        step1.fillEmail("thuyld@gmail.com");
        step1.fillBirthMonth("November");
        step1.fillBirthDay("20");
        step1.fillBirthYear("1993");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, -2000);"); // Scroll up by 500 pixels
        Thread.sleep(Duration.ofSeconds(1));

        step1.clickBtnNext();

        logger.info("Go to Step 2");
        StepTwo step2 = new StepTwo(driver);
        //verify title step 2
        step2.verifyStep2();

        //Type city
        step2.fillCity("ho chi minh");
        Thread.sleep(Duration.ofSeconds(1));

        //input zip
        step2.fillZip("70000");

        // Select country
        step2.fillCountry("Vietnam");

        step2.clickNext();
        Thread.sleep(Duration.ofMillis(1000));

        logger.info("Go to Step 3");
        StepThree step3 = new StepThree(driver);

        //Click mobile device
        step3.fillMobileDevice();

        //Click model
        step3.fillModel();

        //Click operate System
        step3.filloperateSystem();

        //Click next
        step3.clickNext();
        logger.info("Go to Step 4");


        StepFour step4 = new StepFour(driver);

        //input weak password
        step4.fillPassword("Thuy123456");

        //Define softassert

        SoftAssert softAssert = new SoftAssert();

        //Verify password is weak
        SoftAssertFunction.checkEquals(softAssert,step4.getPassStrength(),"weak","Verify title is Weak");

        //Clear password
        step4.clearPassword();

        //input good password
        step4.fillPassword("Thuy123456$");

        SoftAssertFunction.checkEquals(softAssert,step4.getPassStrength(),"good","Verify title is Good");

        //Clear password
        step4.clearPassword();

        //input Great password
        step4.fillPassword("Thuy123456$7890");

        //Verify password is Great

        SoftAssertFunction.checkEquals(softAssert,step4.getPassStrength(),"great", "Verify title is Great");


        softAssert.assertAll();




    }

}
