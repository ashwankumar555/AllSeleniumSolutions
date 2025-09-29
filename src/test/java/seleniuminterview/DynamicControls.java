package seleniuminterview;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DynamicControls {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/dynamic_controls");
		driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		String expected = driver.findElement(By.xpath("//p[@id='message']")).getText();
		Assert.assertEquals(expected, "It's gone!", "Test is Passed");
		driver.findElement(By.xpath("//button[@onclick='swapInput()']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		String expected2 = driver.findElement(By.xpath("//p[@id='message']")).getText();
		Assert.assertEquals(expected2, "It's enabled!", "Test is Passed");
		driver.findElement(By.xpath("//form/input[@type='text']")).sendKeys("ashwin");
	}
}
