package seleniuminterview;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;
import java.time.Duration;

public class AllActionClass {
    public static void main(String[] args) throws InterruptedException {
        
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Navigate to a practice site with all interaction elements
        driver.get("https://demoqa.com/buttons");
        Thread.sleep(4000);

        // Initialize Actions class
        Actions actions = new Actions(driver);

        // 1. Double Click
        WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));
        actions.doubleClick(doubleClickBtn).perform();

        // 2. Right Click (Context Click)
        WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));
        actions.contextClick(rightClickBtn).perform();

        // 3. Click and hold (we'll use another element for this)
        driver.get("https://jqueryui.com/droppable/");
        driver.switchTo().frame(0); // switch to frame that contains the drag-drop elements

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        // 4. Drag and Drop
        actions.dragAndDrop(source, target).perform();

        // 5. Click and hold, move, and release (alternative drag-drop)
        actions.clickAndHold(source).moveToElement(target).release().perform();

        // 6. Move to Element (Mouse Hover)
        driver.switchTo().defaultContent(); // go back to main content
        driver.get("https://demoqa.com/menu/");
        WebElement hoverElement = driver.findElement(By.xpath("//a[text()='Main Item 2']"));
        actions.moveToElement(hoverElement).perform();

        // 7. Keyboard Actions (e.g. typing with SHIFT key)
        driver.get("https://demoqa.com/text-box");
        WebElement inputBox = driver.findElement(By.id("userName"));
        actions.click(inputBox)
                .keyDown(Keys.SHIFT)
                .sendKeys("test user")
                .keyUp(Keys.SHIFT)
                .perform();

        // 8. Move by Offset (move mouse by coordinates)
        actions.moveByOffset(50, 50).click().perform();
        }
    }
