import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

public class FluentWait {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Fluent wait declaration
        Wait<WebDriver> myWait = new org.openqa.selenium.support.ui.FluentWait<WebDriver>(driver)
                      .withTimeout(Duration.ofSeconds(30))
                      .pollingEvery(Duration.ofSeconds(5))
                      .ignoring(NoSuchElementException.class);

        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("Selenium");
        driver.findElement(By.name("q")).sendKeys(Keys.RETURN);

        //Usage of Fluent wait
        WebElement element = myWait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath("//a[@href='https://www.selenium.dev/']//h3[@class='LC20lb MBeuO DKV0Md'][normalize-space()='Selenium']"));
            }
        });

        element.click();

    }

}
