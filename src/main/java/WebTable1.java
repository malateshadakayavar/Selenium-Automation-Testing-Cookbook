import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.tutorialspoint.com/selenium/practice/webtables.php");

        // To get how many rows in a table
        int rows = driver.findElements(By.xpath("//table[@class='table table-striped mt-3']/tbody/tr")).size();
        System.out.println("Total number of rows : "+rows);

        // To find the number of columns
        int columns = driver.findElements(By.xpath("//table[@class='table table-striped mt-3']/thead/tr/th")).size();
        System.out.println("Total number of columns : "+columns);

        //To retrieve the specific row & column
        String value = driver.findElement(By.xpath("//table[@class='table table-striped mt-3']//tr[2]/td[1]")).getText();
        System.out.println("The value is : "+value);

        //To retrieve all the data from the table
        System.out.println("The data from the table");
        for(int r=1;r<=rows;r++){
            for(int c=1;c<=columns;c++){
                String data = driver.findElement(By.xpath("//table[@class='table table-striped mt-3']//tr["+r+"]/td["+c+"]")).getText();
                System.out.print(data+ "        ");
            }
            System.out.println();
        }
        System.out.println("*******************************************************");
        // To print the Last Name & age of Alden
        for(int r=1;r<=rows;r++){
            String name = driver.findElement(By.xpath("//table[@class='table table-striped mt-3']//tr["+r+"]/td[1]")).getText();
            if(name.equals("Alden")){
                String lastName = driver.findElement(By.xpath("//table[@class='table table-striped mt-3']//tr["+r+"]/td[2]")).getText();
                String age = driver.findElement(By.xpath("//table[@class='table table-striped mt-3']//tr["+r+"]/td[3]")).getText();
                System.out.println(name +"   "+lastName+"   "+age);
            }

        }



    }
}
