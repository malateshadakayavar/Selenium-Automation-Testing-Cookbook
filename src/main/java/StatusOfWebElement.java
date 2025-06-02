import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StatusOfWebElement {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        driver.get("https://demo.nopcommerce.com/register");
        WebElement searchStore = driver.findElement(By.xpath("//input[@id='small-searchterms']"));
        System.out.println("Display status : "+searchStore.isDisplayed());
        System.out.println("Display status : "+searchStore.isEnabled());

        //isSelected is used for radio buttons, check boxes, drop downs

        WebElement male = driver.findElement(By.xpath("//input[@id='gender-male']"));
        WebElement female = driver.findElement(By.xpath("//input[@id='gender-female']"));

        System.out.println(male.isSelected());  //false
        System.out.println(female.isSelected());  // false

        male.click();
        System.out.println(male.isSelected());  //true
        System.out.println(female.isSelected());  // false

        female.click();
        System.out.println(male.isSelected());  //false
        System.out.println(female.isSelected());  // true



    }
}
