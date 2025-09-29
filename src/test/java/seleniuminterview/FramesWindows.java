package seleniuminterview;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FramesWindows {

	public static void main(String[] args) throws InterruptedException, IOException {
		Runtime.getRuntime().exec("taskkill /F /IM chrome.exe /T"); 
		/*
		 * WebDriver driver = new ChromeDriver();
		 * driver.get("https://the-internet.herokuapp.com/nested_frames");
		 * Thread.sleep(5000); WebElement frametop =
		 * driver.findElement(By.xpath("//frameset/frame[@name='frame-top']"));
		 * driver.switchTo().frame(frametop); WebElement frameleft =
		 * driver.findElement(By.xpath("//frameset/frame[@name='frame-left']"));
		 * driver.switchTo().frame(frameleft);
		 * System.out.println(driver.findElement(By.tagName("body")).getText());
		 * driver.switchTo().parentFrame(); WebElement framemiddle =
		 * driver.findElement(By.xpath("//frameset/frame[@name='frame-middle']"));
		 * driver.switchTo().frame(framemiddle); //Getting into frame by WebElement
		 * System.out.println(driver.findElement(By.tagName("body")).getText());
		 * driver.switchTo().parentFrame(); driver.switchTo().frame(2); //Getting into
		 * frame by frame index
		 * System.out.println(driver.findElement(By.tagName("body")).getText());
		 * driver.switchTo().parentFrame(); //Switching back to parent frame
		 * driver.switchTo().parentFrame(); //WebElement framebottom =
		 * driver.findElement(By.xpath("//frameset/frame[@name='frame-bottom']"));
		 * driver.switchTo().frame("frame-bottom"); //Getting into frame by frame name
		 * System.out.println(driver.findElement(By.tagName("body")).getText());
		 * driver.close();
		 */Thread.sleep(1000);
		 ChromeOptions options = new ChromeOptions();
		 options.addArguments("--disable-blink-features=AutomationControlled");
		 options.addArguments("--disable-features=SameSiteByDefaultCookies");
		 options.addArguments("--disable-popup-blocking");
		 options.addArguments("--incognito");
		 options.addArguments("--disable-extensions");
		 options.addArguments("--blink-settings=imagesEnabled=false"); // disables ads/images

		 WebDriver driver = new ChromeDriver(options);
		 driver.manage().window().maximize();
		 driver.get("https://demoqa.com/browser-windows");

		 // Get parent window handle
		 String parentwindowhandle = driver.getWindowHandle();
		 System.out.println("Parent Handle: " + parentwindowhandle);

		 Thread.sleep(4000);

		 // Click button to open new tab
		 driver.findElement(By.id("tabButton")).click();

		 // Get all window handles
		 Set<String> allHandles = driver.getWindowHandles();
		 String childwindowhandle = null;

		 // Identify child handle
		 for (String handle : allHandles) {
		     if (!handle.equals(parentwindowhandle)) {
		         childwindowhandle = handle;
		         break;
		     }
		 }

		 System.out.println("Child Handle: " + childwindowhandle);

		 // Switch to child window
		 driver.switchTo().window(childwindowhandle);
		 System.out.println("Child Window Text: " + driver.findElement(By.tagName("h1")).getText());

		 // Switch back to parent
		 driver.switchTo().window(parentwindowhandle);
		 System.out.println("Back to Parent: " + driver.findElement(By.id("tabButton")).getText());

	}
}
