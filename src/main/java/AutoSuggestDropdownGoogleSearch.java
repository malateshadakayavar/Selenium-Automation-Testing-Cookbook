import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class AutoSuggestDropdownGoogleSearch {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.get("https://www.google.com/");

        driver.findElement(By.id("APjFqb")).sendKeys("Java");
        List<WebElement> list = driver.findElements(By.xpath("//li[@class='sbct PZPZlf']//div//div[1][@role='option']//div[1]//span"));

        System.out.println("Size of auto suggestion : " + list.size());

        for(WebElement listItem : list){
            if(listItem.getText().equals("java interview questions")){
                listItem.click();
                break;
            }
        }

    }
}
