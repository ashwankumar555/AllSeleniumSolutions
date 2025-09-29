package seleniuminterview;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class HoversExample {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open Hovers page
        driver.get("https://the-internet.herokuapp.com/hovers");

        // Find all avatar images
        List<WebElement> images = driver.findElements(By.cssSelector(".figure"));

        // Actions class
        Actions actions = new Actions(driver);

        // Hover over each image and print caption
        for (int i = 0; i < images.size(); i++) {
            WebElement image = images.get(i);

            // Hover
            actions.moveToElement(image).perform();
            Thread.sleep(1000);

            // Get caption text (it becomes visible after hover)
            WebElement caption = image.findElement(By.className("figcaption"));
            String text = caption.getText();
            System.out.println("User " + (i + 1) + " details:\n" + text);
        }

        driver.quit();
    }
}
