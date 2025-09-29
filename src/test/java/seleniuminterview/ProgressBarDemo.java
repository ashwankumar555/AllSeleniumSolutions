package seleniuminterview;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProgressBarDemo {
    public static void main(String[] args) {
    	ChromeOptions options = new ChromeOptions();
		 options.addArguments("--disable-blink-features=AutomationControlled");
		 options.addArguments("--disable-features=SameSiteByDefaultCookies");
		 options.addArguments("--disable-popup-blocking");
		 options.addArguments("--incognito");
		 options.addArguments("--disable-extensions");
		 options.addArguments("--blink-settings=imagesEnabled=false"); // disables ads/images

		 WebDriver driver = new ChromeDriver(options);
		 driver.manage().window().maximize();
		 
        driver.get("https://demoqa.com/progress-bar");

        // Locate start button
        WebElement startButton = driver.findElement(By.id("startStopButton"));
        startButton.click();

        // Wait until progress bar reaches 100%
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(
                By.xpath("//div[@role='progressbar']"), "100%"));

        // Fetch progress bar text
        String progressValue = driver.findElement(By.xpath("//div[@role='progressbar']")).getText();
        System.out.println("Progress bar completed at: " + progressValue);

        // Validate completion
        if (progressValue.equals("100%")) {
            System.out.println("✅ Test Passed: Progress bar reached 100%");
        } else {
            System.out.println("❌ Test Failed: Progress bar value = " + progressValue);
        }

        driver.quit();
    }
}