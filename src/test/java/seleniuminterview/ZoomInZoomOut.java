package seleniuminterview;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZoomInZoomOut {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String zoomOut = "document.body.style.zoom='50.0%'";
		js.executeScript(zoomOut);
	}
}
