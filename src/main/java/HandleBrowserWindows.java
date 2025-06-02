import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HandleBrowserWindows {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

        //getWindowHandle
        //getWindowHandles

        String windowID = driver.getWindowHandle();
        System.out.println(windowID);

        driver.findElement(By.id("newTabBtn")).click();
        Set<String> windowIDs =  driver.getWindowHandles();

        //Method 1 - using Iterator();
       /* Iterator<String> it = windowIDs.iterator();
        String parentWindowId = it.next();
        String childWindowId = it.next();
        System.out.println("Parent Window ID : "+parentWindowId);
        System.out.println("Child window ID : "+childWindowId);*/

        //Method 2 - using List/ArrayList
        List<String> windowIDList = new ArrayList<>(windowIDs); //Converting Set --> List
       /* String parentWindowId = windowIDList.get(0);
        String childWindowId = windowIDList.get(1);
        System.out.println("Parent Window ID : "+parentWindowId);
        System.out.println("Child window ID : "+childWindowId);

        //How to use Window IDs to switch
        driver.switchTo().window(parentWindowId);
        System.out.println("Parent window title : "+driver.getTitle());

        driver.switchTo().window(childWindowId);
        System.out.println("Child window title : "+driver.getTitle());*/

        //using for each loop
       /* for(String winID : windowIDList){
            String title = driver.switchTo().window(winID).getTitle();
            System.out.println(title);
        }*/

        //driver.close();  //closes the current window
        //driver.quit();  // closes al the windows open.

        //Closing the specific window
        for(String winID : windowIDList) {
            String title = driver.switchTo().window(winID).getTitle();
            if(title.equals("Window Handles Practice - H Y R Tutorials")){
                driver.close();
            }
        }
    }
}
