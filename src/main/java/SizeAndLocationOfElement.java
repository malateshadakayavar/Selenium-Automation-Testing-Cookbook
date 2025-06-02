import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SizeAndLocationOfElement {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demo.nopcommerce.com/");

        WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));

        //LOcation - Method 1
        System.out.println("Location x,y : "+logo.getLocation());
        System.out.println("Location x :"+logo.getLocation().getX());
        System.out.println("Location y : "+logo.getLocation().getY());

        //LOcation - Method 2
        System.out.println("Location x :"+logo.getRect().getX());
        System.out.println("Location y : "+logo.getRect().getY());

        //Size - method 1
        System.out.println("Size(Height, Width) : "+logo.getSize());
        System.out.println("Size - Height :"+logo.getSize().getHeight());
        System.out.println("Size - Width :"+logo.getSize().getWidth());

        //Size - method 2
        System.out.println("Size - Height :"+logo.getRect().getDimension().getHeight());
        System.out.println("Size - Width :"+logo.getRect().getDimension().getWidth());

        driver.close();


    }
}
