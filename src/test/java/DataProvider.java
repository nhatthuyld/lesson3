
import common.FileGeneration;
import org.PageObject.*;
import org.testng.annotations.Test;
import java.util.HashMap;

public class DataProvider extends TestcaseBase {

    @Test(dataProvider = "csvDataProvider", dataProviderClass = FileGeneration.class)
    public void FillInfo(HashMap<String, String> data) throws InterruptedException {

        Homepage homepage = new Homepage(driver);
        homepage.JoinNow();

        StepOne step1 = new StepOne(driver);

       // String path = "src//Data//example.csv";

        step1.fillFirstName(data.get("firstname"));
        step1.fillLastName(data.get("lastname"));
        step1.fillEmail(data.get("email"));
        step1.fillBirthMonth(data.get("MOB"));
        step1.fillBirthDay(data.get("DOB"));
        step1.fillBirthYear(data.get("YOB"));


    }

}
