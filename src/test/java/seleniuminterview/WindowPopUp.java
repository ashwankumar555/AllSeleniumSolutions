package seleniuminterview;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowPopUp {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		//driver.get("https://the-internet.herokuapp.com/");
		driver.get("http://admin:admin@the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("a[href='/basic_auth']")).click();
	}
}
