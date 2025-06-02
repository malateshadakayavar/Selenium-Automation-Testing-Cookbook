import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActions {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/key_presses");
        Actions act = new Actions(driver);

        act.sendKeys(Keys.ENTER).perform();
        act.sendKeys(Keys.BACK_SPACE).perform();
        act.sendKeys(Keys.SPACE).perform();
        act.sendKeys(Keys.ESCAPE).perform();



    }
}
