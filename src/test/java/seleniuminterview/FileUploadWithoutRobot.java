package seleniuminterview;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadWithoutRobot {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver(); 
        driver.get("https://example.com/upload"); 
        WebElement upload = driver.findElement(By.id("fileUpload")); 
        upload.sendKeys("C:/path/to/file.txt"); 
        driver.findElement(By.id("submitBtn")).click(); 
        driver.quit();

	}

}
