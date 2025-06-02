import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HandleCheckBox {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://testautomationpractice.blogspot.com/");

        //Select specific checkbox
        //driver.findElement(By.xpath("//input[@id='monday']")).click();

        //Select all the check boxes
        List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
        System.out.println("Total number of checkboxes : "+checkBoxes.size());

        //using for loop
        for (WebElement checkBox : checkBoxes) {
            checkBox.click();
        }

        //Select multiple check boxes based on choice
        // Monday & Sunday
        for (WebElement checkBox : checkBoxes) {
            String checkboxName = checkBox.getAttribute("id");
            if(checkboxName.equals("sunday") || checkboxName.equalsIgnoreCase("Monday")){
                checkBox.click();
            }
        }

        //Select last 2 check boxes
        // Starting index =  tot no of check box - no of check box want to select
        // 7-2 = 5
        int noOfCheckboxes = checkBoxes.size();
        for(int i=noOfCheckboxes-2;i<noOfCheckboxes;i++){
                checkBoxes.get(i).click();
        }

        //Select first 2 check boxes
        for(int i=0;i<noOfCheckboxes;i++){
            if(i<2){
                checkBoxes.get(i).click();
            }
        }

    }
}
