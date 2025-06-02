import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderExample {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.globalsqa.com/demo-site/sliders/#Range");
        WebElement min_slider = driver.findElement(By.xpath("//span[1]"));
        System.out.println("The location of min slider is  :"+min_slider.getLocation());  //(909, 70)
        System.out.println("Height & Width of the element : "+min_slider.getSize());  // (14, 17)

        Actions act = new Actions(driver);
        act.dragAndDropBy(min_slider, 100, 0 ).perform();

        System.out.println("The location of min slider is  :"+min_slider.getLocation());  //(909, 70)
        System.out.println("Height & Width of the element : "+min_slider.getSize());  // (14, 17)

        WebElement max_slider = driver.findElement(By.xpath("//span[2]"));
        act.dragAndDropBy(max_slider, -50, 0).perform();



    }
}
