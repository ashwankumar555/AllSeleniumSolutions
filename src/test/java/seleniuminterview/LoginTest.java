package seleniuminterview;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver(); 
		try { 
        driver.get("https://www.saucedemo.com/"); 
        driver.findElement(By.id("user-name")).sendKeys("standard_user"); 
        driver.findElement(By.id("password")).sendKeys("secret_sauce"); 
        driver.findElement(By.id("login-button")).click(); 
		}catch (Exception e) { 
            File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); 
            File dest = new File("errorscreenshot.png"); 
            FileUtils.copyFile(scr, new File("C:\\Users\\user\\OneDrive\\Desktop\\CV\\new.png"));
            scr.renameTo(dest); 
        }
        boolean success = driver.findElement(By.tagName("span")).getText().equalsIgnoreCase("Products");
        System.out.println("Login successful: " + success); 
        //driver.quit(); 
	}
}
