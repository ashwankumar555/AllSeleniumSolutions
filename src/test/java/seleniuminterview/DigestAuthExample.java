package seleniuminterview;

import org.openqa.selenium.By;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DigestAuthExample {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

        // Register credentials before navigating
        ((HasAuthentication) driver).register(UsernameAndPassword.of("admin", "admin"));

        driver.get("https://the-internet.herokuapp.com/digest_auth");

        // Optional: check some element on the page to verify you have access
        String heading = driver.findElement(By.tagName("h3")).getText();
        System.out.println("Page heading: " + heading);
        
        String content = driver.findElement(By.cssSelector("div.example p")).getText();
        System.out.println("Page content: " + content);

        driver.quit();

	}

}
