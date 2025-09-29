package seleniuminterview;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitsPractise {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements());
		
		// FluentWait setup
        Wait<WebDriver> fluentwait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))          // total wait max
                .pollingEvery(Duration.ofSeconds(2));         // check every 2 sec

        // Wait until "Add to Cart" button is clickable
        WebElement addToCartBtn = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("add-to-cart"))
        );
        addToCartBtn.click();
	}
}
