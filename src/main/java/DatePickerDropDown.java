import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class DatePickerDropDown {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.globalsqa.com/demo-site/datepicker/#Simple%20Date%20Picker");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        driver.findElement(By.xpath("//li[@id='DropDown DatePicker']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@id='datepicker']")).click();

        Select monthDrp = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
        monthDrp.selectByVisibleText("Aug");

        Select yeardrp = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
        yeardrp.selectByVisibleText("1995");

        String date = "15";
        List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody/tr/td"));

        for(WebElement ele : allDates){
            String dt = ele.getText();
            if(dt.equals(date)){
                ele.click();
                break;
            }
        }

    }
}
