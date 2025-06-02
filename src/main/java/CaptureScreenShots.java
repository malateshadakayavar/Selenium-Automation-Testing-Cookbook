import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class CaptureScreenShots {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //Full page screen shot
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File trg = new File(".\\screenshots\\homepage.png");
        FileUtils.copyFile(src, trg);

        //Screenshot of section/portion of the page
        WebElement section = driver.findElement(By.xpath("//body/div[3]/div[1]/fieldset[1]"));
        File src1 = section.getScreenshotAs(OutputType.FILE);
        File trg1 = new File(".\\screenshots\\table.png");
        FileUtils.copyFile(src1, trg1);

        driver.close();
    }
}
