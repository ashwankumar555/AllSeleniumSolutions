package seleniuminterview;

import java.io.File;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ValidateFileDownload {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://practice.expandtesting.com/download");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(
		    ExpectedConditions.elementToBeClickable(
		        By.xpath("//a[contains(@data-testid,'csv-microsoft-excel-example-file-upload')]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -100);"); // adjust offset
		Thread.sleep(500);
		element.click();
		
		String downloadPath = System.getProperty("user.home") + "\\Downloads";
		File folder = new File(downloadPath);
		File[] files = folder.listFiles();
		boolean downloaded = Arrays.stream(files).anyMatch(f->f.getName()
				.contains("csv-microsoft-excel-example-file-upload"));
		System.out.println("Download success: "+downloaded);
	}
}
