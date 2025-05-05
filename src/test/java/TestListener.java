import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;

public class TestListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();
        WebDriver driver = ((TestcaseBase) testClass).getDriver(); // phải ép kiểu về base class

        ScreenshotUtil.takeScreenshot(driver, result.getName());
    }
}
