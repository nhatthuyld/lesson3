package org.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Locale;

import static org.testng.AssertJUnit.assertTrue;

public class StepTwo extends BasePage {

    private static String stepTitleTwoXpath = "//span[normalize-space()='Step 2:']";
    private static String cityXpath = "//input[@type='search']";
    private static String cityListSelector = "#cdk-overlay-0 div div";
    private static String zipID = "zip";
    private static String countryID = "countryId";
    private static String nextBtnSelector = "button[class='btn btn-blue'] i[class='material-icons']";


    public StepTwo(WebDriver driver) {

        super(driver);

    }

    public void verifyStep2() {

        String title_step2 = findXpath(stepTitleTwoXpath).getText();
        assertTrue("Step 2 not found", title_step2.contains("Step 2:"));
    }

    public void fillCity(String cityValue) {

        findXpath(cityXpath).sendKeys(cityValue);
        // 3. Wait briefly if needed (or use WebDriverWait)
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }

        // 4. Get options and click the one you want
        List<WebElement> cityOptions = driver.findElements(By.cssSelector(cityListSelector));
        for (WebElement option : cityOptions) {
            if (option.getText().toLowerCase().contains(cityValue)) {
                option.click();
                break;
            }
        }
    }

    public void fillZip(String zipValue) {

        findByID(zipID).clear();
        findByID(zipID).sendKeys(zipValue);

    }

    public void fillCountry(String countryValue) {

        WebElement country_Select = findByID(countryID);
        Select Country_option = new Select(country_Select);
        Country_option.selectByVisibleText(countryValue);

    }

    public void clickNext() {

        findCSSSelector(nextBtnSelector).click();
    }
}
