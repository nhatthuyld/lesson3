import org.openqa.selenium.WebDriver;

public class Step1Object {

     WebDriver webdriver ;

    private static String firstNameID = "firstName";
    private static String firstNameString = "nhat";

    public Step1Object(WebDriver driver){
         this.webdriver = driver;
    }
    ShareFile sf = new ShareFile(webdriver);


    public void fillFirstName( ){

        sf.findByID(firstNameID).sendKeys(firstNameString);

    }
}
