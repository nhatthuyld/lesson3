import org.openqa.selenium.WebDriver;

public class HomepageObject {

    WebDriver webdriver ;
    ShareFile sf;
    private static String linkWeb = "https://www.utest.com";
    private static String acceptCookie ="//button[@id='onetrust-accept-btn-handler']";
    private static String joinNowButton ="//a[@class='unauthenticated-nav-bar-new__sign-up']";



    public HomepageObject(WebDriver driver){

        this.webdriver = driver;
        sf = new ShareFile(webdriver);
    }


    public void JoinNow(){

        sf.open_Url(linkWeb);
        sf.findXpath(acceptCookie).click();
        sf.findXpath(joinNowButton).click();

    }
}
