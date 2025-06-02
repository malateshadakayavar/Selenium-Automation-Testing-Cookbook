import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class HandleBrokenLink {
    public static void main(String[] args) throws MalformedURLException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://www.deadlinkcity.com/");
        List<WebElement> links = driver.findElements(By.tagName("a"));
        int brokenLink =0;
        for(WebElement element :links){
            String url = element.getAttribute("href");

            if(url==null || url.isEmpty()){
                System.out.println("URL is Empty");
                continue;
            }
            URL link = new URL(url);

            try {
                HttpURLConnection httpconn = (HttpURLConnection) link.openConnection();
                httpconn.connect();
                if(httpconn.getResponseCode()>=400){
                    System.out.println(httpconn.getResponseCode() +" - "+url+"  is broken link");
                    brokenLink++;
                }
                else{
                    System.out.println(httpconn.getResponseCode()+" - "+url+"  is Valid link");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        System.out.println("No of broken link : "+brokenLink);
        driver.quit();
    }
}
