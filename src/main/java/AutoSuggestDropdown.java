import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class AutoSuggestDropdown {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.get("https://www.bing.com/");

        driver.findElement(By.id("sb_form_q")).sendKeys("Selenium");
        List<WebElement> list = driver.findElements(By.xpath("//li[@class='sa_sg  sa_blue_hv   ']//span"));

        System.out.println("Size of auto suggestion : " + list.size());

        for(WebElement listItem : list){
            if(listItem.getText().equals("selenium download")){
                listItem.click();
                break;
            }
        }

    }
}
