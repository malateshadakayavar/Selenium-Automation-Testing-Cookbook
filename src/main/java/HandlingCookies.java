import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class HandlingCookies {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demo.nopcommerce.com/");

        //How to capture cookies from browser
        Set<Cookie> cookies =  driver.manage().getCookies();
        System.out.println("Size of the cookies : "+cookies.size());

        //How to print the cookies from browser
         for(Cookie cookie : cookies){
             System.out.println(cookie.getName() +" : "+cookie.getValue());
         }

         //How to add cookie to the browser
        Cookie cookiesObj = new Cookie("MyCookie123", "123456787675");
         driver.manage().addCookie(cookiesObj);

         cookies =  driver.manage().getCookies();
        System.out.println("Size of the cookies after adding : "+cookies.size());

        //How to delete a cookie from browser
        //driver.manage().deleteCookie(cookiesObj);
        driver.manage().deleteCookieNamed("MyCookie123");

        cookies =  driver.manage().getCookies();
        System.out.println("Size of the cookies after deleting : "+cookies.size());

        //Dalete all the cookies
        driver.manage().deleteAllCookies();

        driver.close();
    }
}
