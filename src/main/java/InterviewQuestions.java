import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InterviewQuestions {

    public static void main(String[] args) {

        // Launch browser
        // using System.setProperties.
        // using WebDriverManager API
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

//        WebDriverManager.firefoxdriver().setup();
//        WebDriver driver1 = new FirefoxDriver();
//        driver1.get("https://www.google.com");

        System.out.println("The title of the page is : "+driver.getTitle());
        System.out.println("The URL of the page is : "+driver.getCurrentUrl());
        System.out.println("The page source is : "+driver.getPageSource());




    }
}
