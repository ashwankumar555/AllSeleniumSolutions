package seleniuminterview;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddCookieExample {
    public static void main(String[] args) throws InterruptedException, IOException {
    	Runtime.getRuntime().exec("taskkill /F /IM chrome.exe /T"); 
        WebDriver driver = new ChromeDriver();
        
        // Step 1: Login normally
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Step 2: Get cookies
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println("Cookies from first driver: " + cookies);

        driver.quit();
        Thread.sleep(2000);

        // Step 3: Launch new session
        WebDriver newdriver = new ChromeDriver();
        newdriver.get("https://www.saucedemo.com/");

        // Add cookies back to new driver
        for (Cookie c : cookies) {
            newdriver.manage().addCookie(c);
        }
        
        
        newdriver.findElement(By.id("password")).sendKeys("secret_sauce");
        newdriver.findElement(By.id("login-button")).click();
        newdriver.navigate().refresh();
        System.out.println("Now logged in using cookies!");

        // Step 4: Delete cookies in new driver
        System.out.println("Before deleting session-username: " + newdriver.manage().getCookies());
        
        newdriver.manage().deleteCookieNamed("session-username");
        
        System.out.println("After deleting session-username: " + newdriver.manage().getCookies());

        newdriver.manage().deleteAllCookies();
        System.out.println("After deleting all cookies: " + newdriver.manage().getCookies());

        //newdriver.quit();
    }
}