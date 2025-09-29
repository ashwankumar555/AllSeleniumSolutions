package seleniuminterview;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class KeyPressesExample {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            // Navigate to Key Presses page
            driver.get("https://the-internet.herokuapp.com/key_presses");

            // Locate input area (the body itself handles key presses)
            WebElement body = driver.findElement(By.tagName("body"));

            // List of keys to test
            Keys[] keysToTest = {
                Keys.ENTER,
                Keys.ARROW_UP,
                Keys.SPACE,
                Keys.BACK_SPACE,
                Keys.TAB,
                Keys.SEMICOLON  
            };

            Actions actions = new Actions(driver);

            for (Keys k : keysToTest) {
                // Send the key
                actions.sendKeys(body, k).perform();
                Thread.sleep(1000);  // wait a bit so result appears visibly

                // Read result text
                WebElement result = driver.findElement(By.id("result"));
                String resultText = result.getText();
                System.out.println("Pressed: " + k.name() + " → Result text = \"" + resultText + "\"");

                // Simple assertion logic
                if (!resultText.contains(k.name())) {
                    System.err.println("⚠️ Unexpected result for key: " + k.name());
                }
            }

        } finally {
            driver.quit();
        }
    }
}
