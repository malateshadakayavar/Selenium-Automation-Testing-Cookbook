import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BootstrapDropdownGenericMethod {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.hdfcbank.com/");

        driver.findElement(By.xpath("//a[normalize-space()='Select Product Type']")).click();
        List<WebElement> productTypes = driver.findElements(By.xpath("//ul[@class='dropdown1 dropdown-menu']//li"));
        System.out.println("No of options : "+productTypes.size());
        selectOptionFromDropDown(productTypes, "Accounts");

        driver.findElement(By.xpath("//a[normalize-space()='Select Product']")).click();
        List<WebElement> products = driver.findElements(By.xpath("//ul[@class='dropdown2 dropdown-menu']//li"));
        System.out.println("No of options : "+products.size());
        selectOptionFromDropDown(products, "Current Accounts");

    }
    public static void selectOptionFromDropDown(List<WebElement> options, String value){
        for(WebElement option : options){
            if(option.getText().equals(value)){
                option.click();
                break;
            }
        }
    }
}
