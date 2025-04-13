import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Main {
    public static void main(String[] args) {
        // Tự động tải và setup ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Khởi tạo WebDriver
        WebDriver driver = new ChromeDriver();

        // Mở trang web Google
        driver.get("https://www.google.com");

        // In tiêu đề trang
        System.out.println("Page title: " + driver.getTitle());

        // Đóng trình duyệt
        driver.quit();
    }
}
