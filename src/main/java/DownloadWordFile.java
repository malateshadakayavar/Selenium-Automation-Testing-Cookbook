import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.HashMap;

public class DownloadWordFile {
    public static void main(String[] args) {
        String location = System.getProperty("user.dir")+"\\Downloads";

        //Chrome
        /*HashMap prefences = new HashMap();
        prefences.put("download.default_directory", location);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefences);

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);*/

        //Edge Browser
       /* HashMap prefences = new HashMap();
        prefences.put("download.default_directory", location);

        EdgeOptions options = new EdgeOptions();
        options.setExperimentalOption("prefs", prefences);

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver(options); */

        //Firefox browser
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/msword");
        profile.setPreference("browser.download.folderList", 1); // 0 - Desktop, 1-download,
        profile.setPreference("browser.download.dir",location);

        FirefoxOptions oprions = new FirefoxOptions();
        oprions.setProfile(profile);

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver(oprions);

        driver.get("https://file-examples.com/index.php/sample-documents-download/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[@href='https://file-examples.com/index.php/sample-documents-download/sample-doc-download/']")).click();
    }
}
