import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HandleDropdown {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.opencart.com/index.php?route=account/register");
        WebElement countryEle = driver.findElement(By.id("input-country"));

        Select countryDropdown = new Select(countryEle);
        countryDropdown.selectByVisibleText("Canada");
        countryDropdown.selectByValue("67");
        countryDropdown.selectByIndex(13);

        //Selecting the options from dropdown without using the methods
        List<WebElement> allOptions = countryDropdown.getOptions();
        for(WebElement option :allOptions){
            if(option.getText().equals("Cuba")){
                option.click();
            }
        }
    }
}
