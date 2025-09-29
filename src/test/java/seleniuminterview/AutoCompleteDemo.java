package seleniuminterview;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutoCompleteDemo {
    public static void main(String[] args) throws InterruptedException {

    	ChromeOptions options = new ChromeOptions();
		 options.addArguments("--disable-blink-features=AutomationControlled");
		 options.addArguments("--disable-features=SameSiteByDefaultCookies");
		 options.addArguments("--disable-popup-blocking");
		 options.addArguments("--incognito");
		 options.addArguments("--disable-extensions");
		 options.addArguments("--blink-settings=imagesEnabled=false"); // disables ads/images

		 WebDriver driver = new ChromeDriver(options);
		 driver.manage().window().maximize();
        driver.get("https://demoqa.com/auto-complete");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // 1️⃣ Single Auto Complete
        WebElement singleInput = driver.findElement(By.id("autoCompleteSingleInput"));
        singleInput.sendKeys("Re"); // typing partial value

        // Wait for suggestions (by class, not id!)
        List<WebElement> singleSuggestions = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(
                        By.xpath("//div[contains(@class,'auto-complete__option')]")));

        for (WebElement option : singleSuggestions) {
            if (option.getText().equals("Red")) {
                option.click();
                break;
            }
        }
        System.out.println("Selected single color: " + singleInput.getAttribute("value"));

        // 2️⃣ Multiple Auto Complete
        WebElement multipleInput = driver.findElement(By.id("autoCompleteMultipleInput"));
        multipleInput.sendKeys("Bl");

        List<WebElement> multiSuggestions = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(
                        By.xpath("//div[contains(@class,'auto-complete__option')]")));

        for (WebElement option : multiSuggestions) {
            if (option.getText().equals("Blue")) {
                option.click();
                break;
            }
        }

        multipleInput.sendKeys("Gr");
        multiSuggestions = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(
                        By.xpath("//div[contains(@class,'auto-complete__option')]")));

        for (WebElement option : multiSuggestions) {
            if (option.getText().equals("Green")) {
                option.click();
                break;
            }
        }

        // Print selected multiple values
        List<WebElement> selectedColors = driver.findElements(
                By.cssSelector("div.auto-complete__multi-value__label"));

        System.out.print("Selected multiple colors: ");
        for (WebElement color : selectedColors) {
            System.out.print(color.getText() + " ");
        }

        Thread.sleep(2000);
        driver.quit();
    }
}
