import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HandleLinks {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.amazon.in/");
        //driver.findElement(By.linkText("Today's Deals")).click();
        //driver.findElement(By.partialLinkText("Deals")).click();

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("No of links present : "+links.size());

        for(int i=0;i<links.size();i++){
            String linkName = links.get(i).getText();
            System.out.println("Link name : "+linkName);
            System.out.println(links.get(i).getAttribute("href"));

            // http://www.deadlinkcity.com/
        }

    }
}
