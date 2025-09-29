package seleniuminterview;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EntryAdTest {

    public static void main(String[] args) {
        // Setup WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open the URL
        driver.get("https://the-internet.herokuapp.com/entry_ad");

        // Wait for modal to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal")));

        System.out.println("Modal displayed: " + modal.isDisplayed());

        // Close the modal by clicking "Close"
        WebElement closeButton = driver.findElement(By.cssSelector(".modal-footer p"));
        closeButton.click();

        // Wait until modal disappears
        wait.until(ExpectedConditions.invisibilityOf(modal));

        System.out.println("Modal closed successfully!");

        // Close the browser
        driver.quit();
    }
}
