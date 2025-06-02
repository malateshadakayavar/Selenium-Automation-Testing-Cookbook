import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenURLsIn2Tabs {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demo.nopcommerce.com/");
      //  driver.switchTo().newWindow(WindowType.TAB);

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.opencart.com/");
    }
}
