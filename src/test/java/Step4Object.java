import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Step4Object {

    WebDriver webdriver;
    ShareFile sf;

    private static String passwordStrengthID = "password";
    private static String passStrengthID = "//div[@class='pass-instruction']//h4";




    public Step4Object(WebDriver driver) {

        this.webdriver = driver;
        sf = new ShareFile(webdriver);
    }

    public void fillPassword(String password) {

        WebElement passStrengthElement = sf.findByID(passwordStrengthID);
        passStrengthElement.sendKeys(password);

    }

    public String getPassStrength() {

        String passStrengthText = sf.findXpath(passStrengthID).getText();
        return passStrengthText;

    }

    public void clearPassword() {

        sf.findByID(passwordStrengthID).clear();

    }


}
