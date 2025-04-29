package org.PageObject;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class StepThree extends BasePage {

    private static String mobileDeviceXpath = "//div[@name='handsetMakerId']";
    private static String mobileOptionXpath = "//div[@name='handsetMakerId']//div[contains(text(),'Apple')]";
    private static String modelXpath = "//div[@name='handsetModelId']";
    private static String modelOptionXpath = "//div[@name='handsetModelId']//div[text()='iPhone 16 Pro Max']";
    private static String operateSystemXpath = "//div[@name='handsetOSId']";
    private static String operateSystemOptionXpath = "//div[@name='handsetOSId']//div[text()='iOS 18.5 Beta']";
    private static String nextBtnXpath = "//span[normalize-space()='Next: Last Step']";


    public StepThree(WebDriver driver) {

        super(driver);
    }

    public void fillMobileDevice() throws InterruptedException {

        findXpathToCLickAble(mobileDeviceXpath).click();
        Thread.sleep(Duration.ofMillis(1000));
        findXpathToCLickAble(mobileOptionXpath).click();

    }

    public void fillModel() throws InterruptedException {

        findXpathToCLickAble(modelXpath).click();
        Thread.sleep(Duration.ofMillis(1000));
        findXpathToCLickAble(modelOptionXpath).click();

    }

    public void filloperateSystem() throws InterruptedException {

        findXpathToCLickAble(operateSystemXpath).click();
        Thread.sleep(Duration.ofMillis(1000));
        findXpathToCLickAble(operateSystemOptionXpath).click();

    }

    public void clickNext() {

        findXpathToCLickAble(nextBtnXpath).click();
    }


}
