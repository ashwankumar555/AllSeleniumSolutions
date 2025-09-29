package seleniuminterview;

import java.io.File;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileDownloadValidation {

	public static void main(String[] args) throws InterruptedException {
		 WebDriver driver = new ChromeDriver(); 
	        driver.get("https://example.com/download"); 
	        driver.findElement(By.id("downloadBtn")).click(); 
	        Thread.sleep(5000); 
	        File folder = new File("C:/Downloads"); 
	        File[] files = folder.listFiles(); 
	        boolean downloaded = Arrays.stream(files).anyMatch(f -> f.getName().contains("fileName")); 
	        System.out.println("Download success: " + downloaded); 
	        driver.quit();
	}
}
