package seleniuminterview;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class LargeDeepDomExample {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            driver.get("https://the-internet.herokuapp.com/large");

            // Wait a little for page load
            Thread.sleep(2000);

            // 1. Count all table cells in the big table
            Instant start = Instant.now();
            List<WebElement> cells = driver.findElements(By.cssSelector("table tr td"));
            Instant end = Instant.now();
            long duration = Duration.between(start, end).toMillis();
            System.out.println("Number of table cells: " + cells.size());
            System.out.println("Time taken to find all table cells: " + duration + " ms");

            // 2. Scroll down to bottom and back using JS to test performance / rendering
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            Thread.sleep(2000);
            js.executeScript("window.scrollTo(0, 0)");
            Thread.sleep(1000);

            // 3. Find a deeply nested element (for example, a cell in last row, last column)
            // Let's say we want the cell in row 50, column 50
            WebElement cell5050 = driver.findElement(By.cssSelector("table tr:nth-child(50) td:nth-child(50)"));
            System.out.println("Text in cell (50,50): " + cell5050.getText());

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
