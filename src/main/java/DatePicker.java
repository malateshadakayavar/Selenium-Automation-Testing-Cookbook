import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class DatePicker {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.globalsqa.com/demo-site/datepicker/#Simple%20Date%20Picker");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String year = "2025";
        String month = "July";
        String date = "15";

        driver.findElement(By.xpath("//input[@id='datepicker']")).click();

        while(true){
            String mon = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
            String yr = driver.findElement(By.xpath(" //span[@class='ui-datepicker-year']")).getText();

            if(mon.equalsIgnoreCase(month) && yr.equalsIgnoreCase(year))
                break;
            else
                driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
       }
        // Selection of Date
        List<WebElement> allDates = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']//tbody/tr/td"));
        for(WebElement ele : allDates){
            String dt = ele.getText();
            if(ele.equals(date)){
                ele.click();
                break;
            }
        }

    }
}
