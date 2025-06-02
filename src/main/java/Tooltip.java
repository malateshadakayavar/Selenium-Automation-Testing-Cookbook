import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tooltip {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.globalsqa.com/demo-site/tooltip/");

        driver.switchTo().frame(0);
        WebElement picture = driver.findElement(By.xpath("//img[@alt=\"St. Stephen's Cathedral\"]"));

        String tooltip = picture.getAttribute("value");
        System.out.println("The tool tip is :"+tooltip);
    }
}
