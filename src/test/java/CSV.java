import org.PageObject.*;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

public class CSV extends TestcaseBase {

    @Test
    public void CSVRunAllCase() throws InterruptedException {
        openURL();
        Homepage homepage = new Homepage(driver);
        homepage.JoinNow();

        StepOne step1 = new StepOne(driver);

        String path = "src//Data//example.csv"; // Replace with your actual file path
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(","); // Assuming comma-separated
                step1.fillFirstName(values[0]);
                step1.fillLastName(values[1]);
                step1.fillEmail(values[2]);
                step1.fillBirthMonth(values[3]);
                step1.fillBirthDay(values[4]);
                step1.fillBirthYear(values[5]);

                driver.navigate().refresh();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
