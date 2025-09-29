package seleniuminterview;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollToElementJavascriptExecutor {

	public static void main(String[] args) {
		 // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            // Open webpage
            driver.get("https://www.selenium.dev/");

            // Locate element (e.g., "Selenium Level Sponsors" section at bottom)
            WebElement footerElement = driver.findElement(By.xpath("//h2[contains(text(),'Selenium Level Sponsors')]"));

            // Scroll into view using JavaScriptExecutor
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", footerElement);

            // Highlight for clarity (optional)
            js.executeScript("arguments[0].style.border='3px solid red'", footerElement);

            System.out.println("✅ Scrolled to element: " + footerElement.getText());

            Thread.sleep(3000); // just to see scroll action
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
	}

}
