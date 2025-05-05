package org.PageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open_Url(String url_string) {
        driver.get(url_string);
    }

    public WebElement findXpath(String xpath_string) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath_string)));
        return element;
    }

    public WebElement findXpathToCLickAble(String xpath_string) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath_string)));
        return element;
    }

    public WebElement findCSSSelector(String CSS_string) {
        WebDriverWait wait = new WebDriverWait(driver,  Duration.ofMillis(10000));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CSS_string)));
        return element;    }

    public WebElement findByID(String id_string) {
        WebDriverWait wait = new WebDriverWait(driver,  Duration.ofMillis(10000));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id_string)));
        return element;
    }

    public void SendString(String xpath_String, String s) {

        WebDriverWait wait = new WebDriverWait(driver,  Duration.ofMillis(10000));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath_String)));
        element.sendKeys(s);
    }




}
