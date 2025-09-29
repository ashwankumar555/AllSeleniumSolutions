package seleniuminterview;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FloatingMenuTest {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open URL
        driver.get("https://the-internet.herokuapp.com/floating_menu");

        // Scroll down using JavaScript
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(2000);

        // Locate floating menu
        WebElement floatingMenu = driver.findElement(By.id("menu"));

        if (floatingMenu.isDisplayed()) {
            System.out.println("✅ Floating menu is visible after scrolling.");
        } else {
            System.out.println("❌ Floating menu is not visible.");
        }

        // Click each menu option to verify links
        driver.findElement(By.linkText("Home")).click();
        Thread.sleep(1000);
        driver.navigate().back();

        driver.findElement(By.linkText("News")).click();
        Thread.sleep(1000);
        driver.navigate().back();

        driver.findElement(By.linkText("Contact")).click();
        Thread.sleep(1000);
        driver.navigate().back();

        driver.findElement(By.linkText("About")).click();
        Thread.sleep(1000);
        driver.navigate().back();

        System.out.println("✅ Verified all floating menu links.");

        driver.quit();
    }
}
