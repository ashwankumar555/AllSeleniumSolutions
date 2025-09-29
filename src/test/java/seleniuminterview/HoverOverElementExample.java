package seleniuminterview;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HoverOverElementExample {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            // Open demo page
            driver.get("https://demoqa.com/menu"); // sample site with hover menus

            // Locate the element to hover
            WebElement mainItem = driver.findElement(By.xpath("//a[text()='Main Item 2']"));

            // Create Actions instance
            Actions actions = new Actions(driver);

            // Hover over the element
            actions.moveToElement(mainItem).perform();

            // Locate sub-menu items under Main Item 2
            List<WebElement> subMenuItems = driver.findElements(
                    By.xpath("//a[text()='Main Item 2']/following-sibling::ul/li/a"));

            // Use traditional for loop to print text of each submenu
            for (int i = 0; i < subMenuItems.size(); i++) {
                WebElement item = subMenuItems.get(i);
                System.out.println("Submenu " + (i + 1) + ": " + item.getText());
            }

            System.out.println("✅ Hovered over element: " + mainItem.getText());
            Thread.sleep(3000); // just to visually confirm hover
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
