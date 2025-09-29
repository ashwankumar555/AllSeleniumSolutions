package designPatterns;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class StructuralPatternLoginTest {
    WebDriver driver;
    StructuralPattern loginPage;

       public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new StructuralPattern(driver);
    }

    
    public void testLogin() {
        driver.get("https://example.com/login");
        loginPage.login("admin", "password123");
    }

 
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
