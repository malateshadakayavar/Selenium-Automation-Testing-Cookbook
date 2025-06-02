import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheckDropDownSorted {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practice.expandtesting.com/dropdown");
        WebElement drpElement = driver.findElement(By.id("country"));
        Select drpSelect = new Select(drpElement);

        List<WebElement> options = drpSelect.getOptions();

        ArrayList originalList = new ArrayList();
        ArrayList tempList = new ArrayList();

        for(WebElement option : options){
            originalList.add(option.getText());
            tempList.add(option.getText());
        }
        System.out.println("Original list : "+ originalList);
        System.out.println("Temp list : "+tempList);

        Collections.sort(tempList);  // sorting

        System.out.println("Original list after sorting  : "+ originalList);
        System.out.println("Temp list after sorting : "+tempList);

        if(originalList.equals(tempList)){
            System.out.println("drop down is sorted ");
        }
        else{
            System.out.println("Drop down un sorted");
        }


    }
}
