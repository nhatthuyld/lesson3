import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Step1Object {

    WebDriver webdriver;
    ShareFile sf;

    private static String firstNameID = "firstName";
    private static String firstNameString = "nhat";
    private static String lastNameID = "lastName";
    private static String lastNameString = "thuy";
    private static String emailID = "email";
    private static String emailString = "thuyld@gmail.com";
    private static String birthMonthID="birthMonth";
    private static String birthDayID="birthDay";
    private static String birthYearID="birthYear";
    private static String nextBtn = "//span[normalize-space()='Next: Location']";




    public Step1Object(WebDriver driver) {

        this.webdriver = driver;
        sf = new ShareFile(webdriver);
    }


    public void fillFirstName() {

        sf.findByID(firstNameID).sendKeys(firstNameString);

    }

    public void fillLastName() {

        sf.findByID(lastNameID).sendKeys(lastNameString);

    }

    public void fillEmail() {

        sf.findByID(emailID).sendKeys(emailString);

    }
    public void fillBirthMonth() {

        WebElement select_birthMonth = sf.findByID(birthMonthID);
        Select Select_BM = new Select(select_birthMonth);
        Select_BM.selectByIndex(1);

    }

    public void fillBirthDay() {

        WebElement select_birthDay = sf.findByID(birthDayID);
        Select Select_BD= new Select(select_birthDay);
        Select_BD.selectByVisibleText("11");

    }

    public void fillBirthYear() {

        WebElement select_birthYear = sf.findByID(birthYearID);
        Select Select_BY= new Select(select_birthYear);
        Select_BY.selectByValue("1993");

    }

    public  void clickBtnNext(){

        sf.findXpath(nextBtn).click();

    }
}
