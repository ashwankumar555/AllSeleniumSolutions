package seleniuminterview;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksChecker {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver(); 
        driver.get("https://example.com"); 
        List<WebElement> links = driver.findElements(By.tagName("a")); 
        for (WebElement link : links) { 
            String url = link.getAttribute("href"); 
            if (url != null) { 
                HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection(); 
                conn.setRequestMethod("HEAD"); 
                conn.connect(); 
                if (conn.getResponseCode() >= 400) { 
                    System.out.println("Broken link: " + url); 
                } 
            } 
        } 
        driver.quit(); 
	}

}
