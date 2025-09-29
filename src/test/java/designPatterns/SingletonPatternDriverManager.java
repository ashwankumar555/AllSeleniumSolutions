package designPatterns;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Problem solved: Ensures only one WebDriver instance exists.
//Pattern type: Creational Pattern.

public class SingletonPatternDriverManager {
    private static WebDriver driver;

    private SingletonPatternDriverManager() {}

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
