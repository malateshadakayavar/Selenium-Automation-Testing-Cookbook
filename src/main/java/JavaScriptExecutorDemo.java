import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class JavaScriptExecutorDemo {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Syntax
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript(Script, args);

        driver.get("https://demo.nopcommerce.com/");

        //Draw border & take screenshot
        WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
        JavaScriptUtil.drawBorder(logo, driver);

      /*  TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(".\\screenshots\\logo.png");
        FileUtils.copyFile(src, target);

        //Getting title of the page
        String title = JavaScriptUtil.getTitleByJS(driver);
        System.out.println(title);

        // Click Action
        WebElement regLink = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
        JavaScriptUtil.clickElementByJS(regLink, driver);

        //Generate Alert
        JavaScriptUtil.generateAlert(driver, "This is my Alert");

        //Refresh the page
        JavaScriptUtil.refreshBrowserByJS(driver);

        //Scrolling down the page
        JavaScriptUtil.scrollPageDown(driver);

        //Scrolling up the page
        JavaScriptUtil.scrollPageUp(driver);

        //Zoom page
        JavaScriptUtil.zoomPageByJS(driver);  */

        //Flash
        WebElement logo1 = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
        JavaScriptUtil.flash(logo1, driver);





    }
}
