package org.PageObject;

import org.openqa.selenium.WebDriver;

public class Homepage extends BasePage {

    private static String acceptCookie = "//button[@id='onetrust-accept-btn-handler']";
    private static String joinNowButton = "//a[@class='unauthenticated-nav-bar-new__sign-up']";


    public Homepage(WebDriver driver) {

        super(driver);
    }


    public void JoinNow() {

        findXpath(acceptCookie).click();
        findXpath(joinNowButton).click();

    }
}
