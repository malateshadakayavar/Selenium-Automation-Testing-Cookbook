import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlerts {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //Alert window with OK button
//        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
//        driver.switchTo().alert().accept();

        // Alert window with OK & Cancel button
//        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
//        Thread.sleep(3000);
//        driver.switchTo().alert().accept();  // clicking on OK button
        //driver.switchTo().alert().dismiss(); // clicking on cancel button

        // Alert window with input box, capture text & click action
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
        Alert alertWindow = driver.switchTo().alert();
        System.out.println("The message on the alert window is "+ alertWindow.getText());
        alertWindow.sendKeys("Welcome");
        alertWindow.accept();



    }
}
