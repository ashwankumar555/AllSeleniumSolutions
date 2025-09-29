package seleniuminterview;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JQueryUIMenuTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            driver.get("https://the-internet.herokuapp.com/jqueryui/menu");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            Actions actions = new Actions(driver);

            // Hover over "Enabled" menu
            WebElement enabled = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("ui-id-2"))
            );
            actions.moveToElement(enabled).perform();

            // Hover over "Downloads" submenu under Enabled
            WebElement downloads = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("ui-id-4"))
            );
            actions.moveToElement(downloads).perform();

            // From Downloads, click "PDF"
            WebElement pdfOption = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("ui-id-6"))
            );
            // Sometimes click via JS is more reliable with hidden/overlapping elements
            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", pdfOption);

            // Optionally verify something after click
            System.out.println("Clicked PDF option!");

        } finally {
            driver.quit();
        }
    }
}
