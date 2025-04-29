package org.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class StepOne extends BasePage {

    private static String firstNameID = "firstName";
    private static String lastNameID = "lastName";
    private static String emailID = "email";
    private static String birthMonthID = "birthMonth";
    private static String birthDayID = "birthDay";
    private static String birthYearID = "birthYear";
    private static String nextBtnXpath = "//span[normalize-space()='Next: Location']";

    public StepOne(WebDriver driver) {

        super(driver);

    }


    public void fillFirstName(String firstNameString) {

        findByID(firstNameID).sendKeys(firstNameString);

    }

    public void fillLastName(String lastNameString) {

        findByID(lastNameID).sendKeys(lastNameString);

    }

    public void fillEmail(String emailString) {

        findByID(emailID).sendKeys(emailString);

    }

    public void fillBirthMonth(String birthMonthValue) {

        WebElement select_birthMonth = findByID(birthMonthID);
        Select Select_BM = new Select(select_birthMonth);
        Select_BM.selectByVisibleText(birthMonthValue);

    }

    public void fillBirthDay(String birthDayValue) {

        WebElement select_birthDay = findByID(birthDayID);
        Select Select_BD = new Select(select_birthDay);
        Select_BD.selectByVisibleText(birthDayValue);

    }

    public void fillBirthYear(String birthYearValue) {

        WebElement select_birthYear = findByID(birthYearID);
        Select Select_BY = new Select(select_birthYear);
        Select_BY.selectByValue(birthYearValue);

    }

    public void clickBtnNext() {

        findXpath(nextBtnXpath).click();
    }
}
