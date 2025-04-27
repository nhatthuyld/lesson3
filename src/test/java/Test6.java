import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class Test6 extends TestcaseBase {

    @Test
    public void testCase6() throws InterruptedException {
        ShareFile sf = new ShareFile(driver);
        HomepageObject homepage = new HomepageObject(driver);
        homepage.JoinNow();

        Step1Object step1 = new Step1Object(driver);
        step1.fillFirstName();
        step1.fillLastName();
        step1.fillEmail();
        step1.fillBirthMonth();
        step1.fillBirthDay();
        step1.fillBirthYear();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, -2000);"); // Scroll up by 500 pixels
        Thread.sleep(Duration.ofSeconds(1));

        step1.clickBtnNext();

        Step2Object step2 = new Step2Object(driver);
        //verify title step 2
        step2.verifyStep2();

        //Type city
        step2.fillCity();
        Thread.sleep(Duration.ofSeconds(1));

        //input zip
        step2.fillZip();

        // Select country
        step2.fillCountry();
        step2.clickNext();
        Thread.sleep(Duration.ofMillis(1000));

        Step3Object step3 = new Step3Object(driver);

        //Click mobile device
        step3.fillMobileDevice();

        //Click model
        step3.fillModel();

        //Click operate System
        step3.filloperateSystem();

        //Click next
        step3.clickNext();

        Step4Object step4 = new Step4Object(driver);

        //input weak password
        step4.fillPassword("Thuy123456");

        //get pass strength text
        String passStrengthText = step4.getPassStrength();

        //Verify password is weak
        Assert.assertEquals(passStrengthText, "Weak");

        //Clear password
        step4.clearPassword();

        //input good password
        step4.fillPassword("Thuy123456$");

        //Verify password is good
        Assert.assertEquals(step4.getPassStrength(), "Good");

        //Clear password
        step4.clearPassword();

        //input Great password
        step4.fillPassword("Thuy123456$7890");

        //Verify password is good
        Assert.assertEquals(step4.getPassStrength(), "Great");


    }

}
