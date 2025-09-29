package seleniuminterview;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class DynamicWebTableExample {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/html/html_tables.asp");
        WebElement table = driver.findElement(By.id("customers"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        System.out.println("Total Rows (including header): " + rows.size());
        List<WebElement> header = table.findElements(By.xpath("//tbody[1]/tr[1]/th[1]"));
        System.out.println("Header size: " +header.size());
        
        for (int k = 0; k < header.size(); k++) {
            System.out.print(header.get(k).getText() + " | ");
        }
        System.out.println();
        for (int i = 0; i < rows.size(); i++) {
            List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
            
            if (cols.size() == 0) {
                continue;
            }
            for (int j = 0; j < cols.size(); j++) {
                System.out.print(cols.get(j).getText() + " | ");
            }
            System.out.println();
        }
        driver.quit();
    }
}

