import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jshell.spi.ExecutionControl;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoCompletingGoogleSuggestionDropDown {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

       driver.get("https://demo.automationtesting.in/AutoComplete.html");
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='searchbox']"));
        searchBox.sendKeys("South");

        String text;
        do{
            searchBox.sendKeys(Keys.ARROW_DOWN);
            text = searchBox.getAttribute("value");
            if(text.equals("South Korea")){
                searchBox.sendKeys(Keys.ENTER);
                break;
            }
        }while(!text.isEmpty());

    }
}
