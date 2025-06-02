import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HandleMultipleDropdowns {
    static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebElement noOfEmpELe = driver.findElement(By.name("NoOfEmployees"));
        selectOptinFromDropdown(noOfEmpELe, "16 - 20");

        WebElement industryEle = driver.findElement(By.name("Industry"));
        selectOptinFromDropdown(industryEle, "Healthcare");

        WebElement country = driver.findElement(By.name("Country"));
        selectOptinFromDropdown(country, "Ghana");
    }

        public static void selectOptinFromDropdown(WebElement ele, String value){

            Select drp = new Select(ele);
            List<WebElement> allOptions = drp.getOptions();

            for(WebElement option :allOptions){
                if(option.getText().equals(value)){
                    option.click();
                }
            }



        }
}
