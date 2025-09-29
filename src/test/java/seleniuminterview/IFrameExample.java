package seleniuminterview;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IFrameExample {
    public static void main(String[] args) throws InterruptedException {
        // Launch Chrome
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Navigate to the iframe page
        driver.get("https://the-internet.herokuapp.com/iframe");
        Thread.sleep(5000);
        // Step 1: Switch to iframe by ID
        driver.switchTo().frame("mce_0_ifr");

        // Step 2: Locate editor body and clear text
        WebElement editor = driver.findElement(By.id("tinymce"));
        editor.clear();

        // Step 3: Enter new text
        editor.sendKeys("Hello, Selenium with iFrames!");

        // Step 4: Switch back to main page
        driver.switchTo().defaultContent();

        // Verify page header
        String heading = driver.findElement(By.tagName("h3")).getText();
        System.out.println("Page Heading: " + heading);

        // Close browser
        driver.quit();
    }
}

