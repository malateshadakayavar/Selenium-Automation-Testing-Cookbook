import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HandleJqueryDropDown {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.jqueryscript.net/demo/drop-down-combo-tree/");

        driver.findElement(By.id("JustAnInputBox")).click();
        //selectChoiceValues(driver, "choice1");
        //selectChoiceValues(driver, "choice1", "choice2", "choice 1 2');
        //selectChoiceValues(driver, "all");
    }
        public static void selectChoiceValues (WebDriver driver, String... value){
            List<WebElement> choiceList = driver.findElements(By.xpath(" ex :element "));
            if(!value[0].equalsIgnoreCase("all")){
                for(WebElement item : choiceList){
                    String text = item.getText();
                    for(String val : value){
                        if(text.equals(val)){
                            item.click();
                            break;
                        }
                    }
                }
            }
            else {
                for(WebElement item : choiceList){
                    item.click();
                }
            }

        }
}
