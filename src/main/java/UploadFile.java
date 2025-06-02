import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class UploadFile {
    public static void main(String[] args) throws AWTException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://tus.io/demo");

        //driver.findElement(By.xpath("//input[@id='P0-0']")).click();

        //Using send keys
        //driver.findElement(By.xpath("//input[@id='P0-0']")).sendKeys("D:\\Malatesh_5+YOE_QA.jpg");

        //Using Robot class method
        WebElement button = driver.findElement(By.xpath("//input[@id='P0-0']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click", button); // click action pn the button

        Robot rb = new Robot();
        rb.delay(2000);

        //put path to file in a clipboard
        StringSelection ss = new StringSelection("D:\\Malatesh_5+YOE_QA.jpg");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        //CTRL + V
        rb.keyPress(KeyEvent.VK_CONTROL); //Press on CTRL key
        rb.keyPress(KeyEvent.VK_V);  //press on CTRL key

        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);

        //ENTER key
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);





    }
}
