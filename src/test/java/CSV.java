import common.FileGeneration;
import org.PageObject.*;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.HashMap;

public class CSV extends TestcaseBase {

    @Test
    public void CSVRunAllCase() throws InterruptedException {
        openURL();
        Homepage homepage = new Homepage(driver);
        homepage.JoinNow();

        StepOne step1 = new StepOne(driver);

        String path = "src//Data//example.csv";
        FileGeneration fileGeneration = new FileGeneration();
        ArrayList<HashMap<String, String>> userInfo = fileGeneration.readCscFile(path);
            for(int i = 0; i< userInfo.size() ; i++) {
                step1.fillFirstName(userInfo.get(i).get("firstname"));
                step1.fillLastName(userInfo.get(i).get("lastname"));
                step1.fillEmail(userInfo.get(i).get("email"));
                step1.fillBirthMonth(userInfo.get(i).get("MOB"));
                step1.fillBirthDay(userInfo.get(i).get("DOB"));
                step1.fillBirthYear(userInfo.get(i).get("YOB"));

                driver.navigate().refresh();

            }



    }

}
