import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClickAction {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://vinothqaacademy.com/mouse-event/");

        WebElement button = driver.findElement(By.xpath("//button[@id='dblclick']"));

        Actions act = new Actions(driver);
        act.doubleClick(button).perform();
    }
}
