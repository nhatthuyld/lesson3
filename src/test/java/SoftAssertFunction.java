import org.testng.ITestListener;
import org.testng.asserts.SoftAssert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SoftAssertFunction implements ITestListener {

    private static final Logger log = LogManager.getLogger(SoftAssertFunction.class);

    //@Test
    public static void checkEquals(SoftAssert softAssert, String actual, String expected, String stepDescription) {
        try {
            softAssert.assertEquals(actual, expected, stepDescription);
        } catch (AssertionError e) {
            log.error(" Fail  [{}] - {}", stepDescription, e.getMessage());
        }
    }

}

