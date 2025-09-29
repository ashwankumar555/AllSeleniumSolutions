package seleniuminterview;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElement {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		WebElement nameBox = driver.findElement(By.name("name"));
		driver.findElement(By.linkText("Shop")).click();
		driver.findElement(By.linkText("Home")).click();
		//nameBox.sendKeys("hello"); //We will get stale element exception, if we dont initiate new WebElement varaible as below
		
		WebElement nameBox1 = driver.findElement(By.name("name"));
		nameBox1.sendKeys("hello");
	}

}
