
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Test2 extends TestcaseBase {

    @Test
    public void testCase2() throws InterruptedException {
        ShareFile sf = new ShareFile(driver);
        sf.open_Url("https://www.utest.com/");
        //click cookie
        sf.findXpath("//button[@id='onetrust-accept-btn-handler']").click();

        //click join now
        sf.findXpath("//a[@class='unauthenticated-nav-bar-new__sign-up']").click();

        //input email
        sf.findXpath("//input[@id='email']").sendKeys("invalice@@email.com");
        Thread.sleep(Duration.ofMillis(500));

        String emailErrorMessage = sf.findXpath("//*[@id='emailError']").getText();
        assertTrue("email error not found!", emailErrorMessage.contains("Enter valid email"));



    }

}
