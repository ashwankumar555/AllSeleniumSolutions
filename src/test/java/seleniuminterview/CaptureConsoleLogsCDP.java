package seleniuminterview;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.devtools.v127.log.model.LogEntry;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;

public class CaptureConsoleLogsCDP {

	 public static void main(String[] args) throws InterruptedException {
	        // Setup ChromeOptions (optional)
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--remote-allow-origins=*"); // helps in some Chrome versions

	        WebDriver driver = new ChromeDriver(options);
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	        try {
	            // Open a site that triggers JS errors
	            driver.get("https://the-internet.herokuapp.com/javascript_error");

	            // Trigger console log (clicking link causes activity in console)
	            driver.findElement(By.linkText("Elemental Selenium")).click();

	            // Wait to allow logs to generate
	            Thread.sleep(3000);

	            // Capture logs using LogType.BROWSER
	            LogEntries logs = driver.manage().logs().get(LogType.BROWSER);
	            logs.forEach(log -> System.out.println(log.getMessage())); 
	        } finally {
	            driver.quit();
	        }
	    }

}
