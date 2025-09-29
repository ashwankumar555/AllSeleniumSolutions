package seleniuminterview;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class DisableImagesChrome {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();

        // Disable image loading
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.managed_default_content_settings.images", 2);  // 2 = block images
        options.setExperimentalOption("prefs", prefs);
        //options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.fintinc.com/");

        System.out.println("✅ Page loaded without images.");
        //driver.quit();
    }
}

