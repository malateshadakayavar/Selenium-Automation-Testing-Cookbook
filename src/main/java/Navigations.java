import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigations {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.snapdeal.com/");
        //driver.get("https://www.amazon.com/");
        driver.navigate().to("https://www.amazon.com/");

        driver.navigate().back();  //back to snapdeal
        driver.navigate().forward(); // amazon

        driver.navigate().refresh(); // refresh / reload the page

    }
}
