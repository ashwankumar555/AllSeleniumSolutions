package seleniuminterview;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InputsExample {
    public static void main(String[] args) throws InterruptedException {
        // Setup
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Navigate
        driver.get("https://the-internet.herokuapp.com/inputs");

        // Locate the input field
        WebElement inputField = driver.findElement(By.tagName("input"));

        // Clear any default value
        inputField.clear();
        Thread.sleep(500);

        // Send numeric value
        inputField.sendKeys("123");
        System.out.println("After direct sendKeys: " + inputField.getAttribute("value"));

        // Use arrow up to increment
        inputField.sendKeys(Keys.ARROW_UP);
        inputField.sendKeys(Keys.ARROW_UP);
        System.out.println("After two ARROW_UP: " + inputField.getAttribute("value"));

        // Use arrow down to decrement
        inputField.sendKeys(Keys.ARROW_DOWN);
        System.out.println("After one ARROW_DOWN: " + inputField.getAttribute("value"));

        // Use decrement beyond zero, etc.
        inputField.sendKeys(Keys.ARROW_DOWN);
        inputField.sendKeys(Keys.ARROW_DOWN);
        System.out.println("After two more ARROW_DOWN: " + inputField.getAttribute("value"));

        // We can also test edge cases: sending non-numeric, decimal, etc.
        // e.g. try sending "." or "-" if supported, then read value

        // Close
        driver.quit();
    }
}
