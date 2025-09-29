package seleniuminterview;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicLoadingTest {

    public static void main(String[] args) {
        // Setup WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        // Go to dynamic loading page
        driver.get("https://the-internet.herokuapp.com/dynamic_loading");

        // ================= Example 1 =====================
        driver.findElement(By.linkText("Example 1: Element on page that is hidden")).click();

        driver.findElement(By.cssSelector("#start button")).click();

        // Explicit wait until element is visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement helloText1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));

        System.out.println("Example 1 Output: " + helloText1.getText());

        driver.navigate().back();

        // ================= Example 2 =====================
        driver.findElement(By.linkText("Example 2: Element rendered after the fact")).click();

        driver.findElement(By.cssSelector("#start button")).click();

        // Wait until the element is present in DOM & visible
        WebElement helloText2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));

        System.out.println("Example 2 Output: " + helloText2.getText());

        // Close driver
        driver.quit();
    }
}

