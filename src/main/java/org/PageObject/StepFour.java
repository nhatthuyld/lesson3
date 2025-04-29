package org.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StepFour extends BasePage {

    private static String passwordID = "password";
    private static String passTitleXpath = "//div[@class='pass-instruction']//h4";

    public StepFour(WebDriver driver) {

        super(driver);
    }

    public void fillPassword(String password) {

        WebElement passStrengthElement = findByID(passwordID);
        passStrengthElement.sendKeys(password);

    }

    public String getPassStrength() {

        String passStrengthText = findXpath(passTitleXpath).getText();
        return passStrengthText;

    }

    public void clearPassword() {

        findByID(passwordID).clear();

    }


}
