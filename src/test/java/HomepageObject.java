import org.openqa.selenium.WebDriver;

public class HomepageObject {

    WebDriver webdriver ;
    private static String linkWeb = "https://www.utest.com";
    private static String acceptCookie ="//button[@id='onetrust-accept-btn-handler']";
    private static String joinNowButton ="//a[@class='unauthenticated-nav-bar-new__sign-up']";
    private static String firstNameID = "firstName";
    private static String firstNameString = "nhat";

    public HomepageObject(WebDriver driver){
        this.webdriver = driver;
    }
    ShareFile sf = new ShareFile(webdriver);

    public void JoinNow(){

        sf.open_Url(linkWeb);
        sf.findXpath(acceptCookie).click();
        sf.findXpath(joinNowButton).click();

    }
}
