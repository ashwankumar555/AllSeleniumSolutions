package seleniuminterview;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class SliderDemo {
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

        driver.get("https://demoqa.com/slider");

        // Locate the slider handle
        WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));

        // Create Actions class instance
        Actions actions = new Actions(driver);

        // Move slider by offset (e.g., +50 pixels on X-axis)
        actions.dragAndDropBy(slider, 50, 0).perform();
        Thread.sleep(2000);

        // Move slider back by offset (-30 pixels)
        actions.dragAndDropBy(slider, -30, 0).perform();
        Thread.sleep(2000);

        // Validate value from slider's input box
        String sliderValue = driver.findElement(By.id("sliderValue")).getAttribute("value");
        System.out.println("Current slider value: " + sliderValue);
        driver.quit();
    }
}
