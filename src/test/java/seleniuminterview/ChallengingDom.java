package seleniuminterview;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChallengingDom {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/challenging_dom");

        // ---- Handle Dynamic Buttons ----
        // Instead of storing once, re-fetch inside the loop
        for (int i = 1; i <= 3; i++) {
            List<WebElement> buttons = driver.findElements(By.xpath("//div[@class='large-2 columns']/a"));
            WebElement btn = buttons.get(i - 1);  // get each button fresh
            System.out.println("Clicking button: " + btn.getText());
            btn.click();
        }

        // ---- Extract Table Headers ----
        List<WebElement> headers = driver.findElements(By.xpath("//table/thead/tr/th"));
        System.out.println("\nTable Headers:");
        for (WebElement header : headers) {
            System.out.print(header.getText() + " | ");
        }
        System.out.println();
        List<WebElement> completerows = driver.findElements(By.xpath("//table/tbody/tr"));
        int i = completerows.size();
        //System.out.println(i);
        for(int j=1;j<=i;j++)
        {
        List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr["+j+"]/td"));
        //System.out.println("\nTable Rows:");
        for (WebElement row : rows) {
            System.out.print(row.getText() + " | ");
        }
        System.out.println();
        }
        System.out.println();
        driver.quit();
    }
}
