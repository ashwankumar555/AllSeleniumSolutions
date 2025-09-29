package seleniuminterview;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HorizontalSliderExample {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open horizontal slider page
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");

        // Locate slider element
        WebElement slider = driver.findElement(By.cssSelector("input[type='range']"));

        // Create Actions class
        Actions actions = new Actions(driver);

        // Move slider step by step (each arrow right = 0.5)
        for (int i = 0; i < 6; i++) {   // move to 3.0
            actions.click(slider).sendKeys(Keys.ARROW_RIGHT).perform();
            Thread.sleep(300); // small pause so we can see movement
        }

        // Capture displayed value
        String value = driver.findElement(By.id("range")).getText();
        System.out.println("Slider value is: " + value);

        // Close browser
        //driver.quit();
    }
}

