import org.apache.logging.log4j.LogManager;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;
import java.util.logging.Logger;

public class TestListener implements ITestListener {

    private static final Logger logger = (Logger) LogManager.getLogger(TestListener.class);

    @Override
    public void onTestFailure(ITestResult result) {
        logger.info(" Test FAILED: " + result.getName());
        Object testClass = result.getInstance();
        WebDriver driver = ((TestcaseBase) testClass).getDriver();
        ScreenshotUtil.capture(driver, result.getName());
        logger.info("📸 Screenshot taken for failed test: " + result.getName());

    }
}
