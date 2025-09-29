package seleniuminterview;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CalendarPractise {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
	    options.addArguments("--disable-notifications"); 
	    WebDriver driver = new ChromeDriver(options);
	    driver.manage().window().maximize();
		String monthNumber = "11";
		String date = "September";
		String year = "2025";
		String fulldate = year+"-"+monthNumber+"-"+date;
		driver.get("https://www.goibibo.com/flights/");
		Thread.sleep(6000);
		driver.findElement(By.cssSelector(".icClose")).click();
		
		driver.findElement(By.xpath("(//div[@class='sc-12foipm-2 eTBlJr fswFld '])[3]")).click();
		driver.findElement(By.xpath("//div[contains(text(),'"+date+"')]")).click();
		driver.findElements(By.xpath("(//div[@role='grid'])[1]//div[@class='DayPicker-Day']")).get(Integer.parseInt(date)-1).click();
	}

}
