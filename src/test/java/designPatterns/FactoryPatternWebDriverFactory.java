package designPatterns;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//Problem solved: Provides driver objects dynamically.
//Pattern type: Creational Pattern.

public class FactoryPatternWebDriverFactory {
    public static WebDriver getDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            return new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            return new FirefoxDriver();
        }
        throw new IllegalArgumentException("Invalid browser: " + browser);
    }
}

// Usage
//WebDriver driver = FactoryPatternWebDriverFactory.getDriver("chrome");

