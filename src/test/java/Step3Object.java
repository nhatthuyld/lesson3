import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Step3Object {
    WebDriver webdriver;
    ShareFile sf;

    private static String mobileDeviceID = "//div[@name='handsetMakerId']";
    private static String mobileOptionID = "//div[@name='handsetMakerId']//div[contains(text(),'Apple')]";
    private static String modelID = "//div[@name='handsetModelId']";
    private static String modelOptionID = "//div[@name='handsetModelId']//div[text()='iPhone 16 Pro Max']";
    private static String OperateSystemID = "//div[@name='handsetOSId']";
    private static String OperateSystemOptionID = "//div[@name='handsetOSId']//div[text()='iOS 18.5 Beta']";
    private static String nextBtnID = "//span[normalize-space()='Next: Last Step']";


    public Step3Object(WebDriver driver) {

        this.webdriver = driver;
        sf = new ShareFile(webdriver);
    }

    public void fillMobileDevice() throws InterruptedException {

        sf.findXpathToCLickAble(mobileDeviceID).click();
        Thread.sleep(Duration.ofMillis(1000));
        sf.findXpathToCLickAble(mobileOptionID).click();

    }

    public void fillModel() throws InterruptedException {

        sf.findXpathToCLickAble(modelID).click();
        Thread.sleep(Duration.ofMillis(1000));
        sf.findXpathToCLickAble(modelOptionID).click();

    }

    public void filloperateSystem() throws InterruptedException {

        sf.findXpathToCLickAble(OperateSystemID).click();
        Thread.sleep(Duration.ofMillis(1000));
        sf.findXpathToCLickAble(OperateSystemOptionID).click();

    }

    public  void clickNext(){

        sf.findXpathToCLickAble(nextBtnID).click();
    }


}
