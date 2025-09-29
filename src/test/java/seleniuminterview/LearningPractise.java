package seleniuminterview;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearningPractise {

	public static void main(String[] args) throws IOException {
		
		Runtime.getRuntime().exec("taskkill /F /IM chrome.exe /T"); 
		WebDriver driver = new ChromeDriver();
		
		//driver.manage().timeouts().setScriptTimeout(1, TimeUnit.MILLISECONDS);
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(400));
		driver.get("https://www.saucedemo.com");
		System.out.println(driver.getCurrentUrl()); //Retrives the current opened url full link
		System.out.println(driver.getTitle()); //gets the title on URL opened
		/*driver.navigate().to("https://www.saucedemo.com");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh(); //Refreshes the current page
		driver.manage().window().maximize();
		driver.manage().window().minimize();
		driver.manage().window().fullscreen();     //sets the browser window to full screen
		System.out.println(driver.manage().window().getSize());   //Returns window size as (1280, 720)
		driver.manage().window().maximize();
		driver.manage().window().setSize(new Dimension(1000, 900));
		System.out.println(driver.manage().window().getSize());  //Here o/p will be (1000, 738). This usually happens because browsers don’t count the OS window frame, menu bar, and toolbars as part of the "inner content area" (the viewport).
		System.out.println(driver.manage().window().getPosition()); //Retrieves the current position of the browser window (10,10)
		driver.manage().window().setPosition(new Point(100,100)); //Sets the position of browser window
		System.out.println(driver.manage().window().getPosition()); //(100,100)
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //Sets of the implicit wait for finding the elements.
		driver.quit();*/
		Runtime.getRuntime().exec("taskkill /F /IM chrome.exe /T"); //To kill all opened chrome windows.
		//String tempPath = System.getenv("TEMP");

		// Delete files
		//Runtime.getRuntime().exec("cmd /c del /q /s \"" + tempPath + "\\*\"");

		// Delete subdirectories
		//Runtime.getRuntime().exec("cmd /c for /d %x in (\"" + tempPath + "\\*\") do @rd /s /q \"%x\"");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(1));
		
	}

}
