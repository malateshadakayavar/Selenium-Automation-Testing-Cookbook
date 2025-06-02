import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTestVsGetAttributeValue {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://admin-demo.nopcommerce.com/login");
        WebElement emailBox = driver.findElement(By.id("Email"));
//        emailBox.clear();
//        emailBox.sendKeys("admin1234@gmail.com");

        //Capturing text from input box
        System.out.println("Result from getAttribute() : "+emailBox.getAttribute("value"));
        System.out.println("Result from getAttribute() : "+emailBox.getText());


        //Login button
        WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Log in']"));
        System.out.println(button.getAttribute("type"));
        System.out.println(button.getAttribute("class"));

        System.out.println(button.getText());
    }
}
