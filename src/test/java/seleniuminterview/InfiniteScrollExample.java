package seleniuminterview;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class InfiniteScrollExample {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open Infinite Scroll page
        driver.get("https://the-internet.herokuapp.com/infinite_scroll");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll down 5 times
        for (int i = 0; i < 5; i++) {
            js.executeScript("window.scrollBy(0, 1000)"); // scroll down by 1000 pixels
            Thread.sleep(2000); // wait for content to load
        }

        // Capture all loaded paragraphs
        List<WebElement> paragraphs = driver.findElements(By.className("jscroll-added"));
        System.out.println("Number of paragraphs loaded: " + paragraphs.size());

        // Print sample text
        for (int i = 0; i < paragraphs.size(); i++) {
            System.out.println("Paragraph " + (i + 1) + ": " + paragraphs.get(i).getText());
        }

        driver.quit();
    }
}
