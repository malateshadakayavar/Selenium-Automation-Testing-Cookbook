import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElementVsFindElements {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demo.nopcommerce.com/");

        //FindElement --> Returns Single element
        //1
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='small-searchterms']"));
        searchBox.sendKeys("Mobile");

        //2
        WebElement footerEle = driver.findElement(By.xpath("//div[@class='footer-upper']//a"));
        System.out.println(footerEle.getText());

        //3  Throws exception --> NoSuchElement (If the element is not available)
        //WebElement searchButon = driver.findElement(By.xpath("//button[normalize-space()='Login']"));

        //FindElements --> Returns multiple web elements
        List<WebElement> links = driver.findElements(By.xpath("//div[@class='footer-upper']//a"));
        System.out.println("No of links present : "+links.size());

        for(WebElement ele :links){
            System.out.println(ele.getText());
        }

        // If the web element is not present -> FindElements will return 0, and doesn't throw any exception.



    }
}
