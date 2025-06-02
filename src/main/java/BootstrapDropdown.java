import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BootstrapDropdown {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.hdfcbank.com/");

        driver.findElement(By.xpath("//a[normalize-space()='Select Product Type']")).click();
        List<WebElement> productTypes = driver.findElements(By.xpath("//ul[@class='dropdown1 dropdown-menu']//li"));
        System.out.println("No of options : "+productTypes.size());
        for(WebElement ptype : productTypes){
            if(ptype.getText().equals("Accounts")){
                ptype.click();
                break;
            }
        }

        driver.findElement(By.xpath("//a[normalize-space()='Select Product']")).click();
        List<WebElement> products = driver.findElements(By.xpath("//ul[@class='dropdown2 dropdown-menu']//li"));
        System.out.println("No of options : "+products.size());
        for(WebElement prods : products){
            if(prods.getText().equals("Current Accounts")){
                prods.click();
                break;
            }
        }

    }
}
