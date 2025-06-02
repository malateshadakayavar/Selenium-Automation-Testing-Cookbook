import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardActionsMultipleKeys {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");

        WebElement input1 = driver.findElement(By.xpath("//input[@name='firstname']"));
        WebElement input2 = driver.findElement(By.xpath("//input[@name='lastname']"));

        input1.sendKeys("Malatesh");

        Actions act = new Actions(driver);

        //Control + A
        act.keyDown(Keys.CONTROL);
        act.sendKeys("a");
        act.keyUp(Keys.CONTROL);
        act.perform();

        //Control + C
        act.keyDown(Keys.CONTROL);
        act.sendKeys("c");
        act.keyUp(Keys.CONTROL);
        act.perform();

        // Tab key to - next
        act.keyDown(Keys.TAB);
        act.perform();

        //Control + V
        act.keyDown(Keys.CONTROL);
        act.sendKeys("v");
        act.keyUp(Keys.CONTROL);
        act.perform();

        //compare the text
        if(input1.getAttribute("value").equals(input2.getAttribute("value")))
            System.out.println("Text copied");
        else
            System.out.println("Text not copied");
    }
}
