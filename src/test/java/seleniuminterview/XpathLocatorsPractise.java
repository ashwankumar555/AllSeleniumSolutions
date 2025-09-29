package seleniuminterview;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathLocatorsPractise {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C://Users//user//OneDrive//Desktop//Sample.html");
		//String h1tag = driver.findElement(By.xpath("//h1")).getText();
		//System.out.println(h1tag);
		driver.findElement(By.xpath("//input[@id='username' and @name='user' and @type='text']")).sendKeys("Ashwin");
		driver.findElement(By.xpath("//input[@id='username' or @name='user' or @type='text']")).sendKeys("Ganji");
		driver.findElement(By.xpath("//a[contains(text(), 'Sign Up')]")).click();
		driver.navigate().back();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[normalize-space(text()='Sign Up')]")).click();
		driver.navigate().back();
		driver.findElement(By.xpath("//input[contains(@placeholder, 'password')]")).sendKeys("Kumar");
		driver.findElement(By.xpath("//input[starts-with(@id, 'use')]")).sendKeys("Akhira");
		driver.findElement(By.xpath("//input[starts-with(@id, 'pas')]")).sendKeys("1234567");
		//driver.findElement(By.xpath("//input[ends-with(@placeholder, 'name')]")).sendKeys("Amyra");
		//driver.findElement(By.xpath("//input[ends-with(@placeholder, 'word')]")).sendKeys("1234567");
		System.out.println(driver.findElement(By.xpath("//input[@id='username']/parent::div")).getText());
		
		List<WebElement> list = driver.findElements(By.xpath("//th[contains(text(),'Name')]/parent::tr"));
		for(WebElement ele : list)
		{
			System.out.println(ele.getText());
		}
		List<WebElement> list2 = driver.findElements(By.xpath("//ul[contains(@id,'menu')]/child::li"));
		for(WebElement ele : list2)
		{
			System.out.println(ele.getText());
		}
		
		System.out.println(driver.findElement(By.xpath("//li[text()='Products']/following-sibling::li")).getText());
		System.out.println(driver.findElement(By.xpath("//li[text()='Products']/preceding-sibling::li")).getText());
		System.out.println(driver.findElement(By.xpath("//div[@id='container']//h1[@class='title']")).getText());
		System.out.println(driver.findElement(By.xpath("//table[@id='employee']//tr[td[text()='Alice']]/td[2]")).getText());
		System.out.println(driver.findElement(By.xpath("//td[text()='John']/ancestor::table")).getAttribute("id"));
		System.out.println(driver.findElement(By.xpath("//div[@id='container']/descendant::a")).getAttribute("class"));
		System.out.println(driver.findElement(By.xpath("//li[1]")).getText());
		System.out.println(driver.findElement(By.xpath("//li[last()]")).getText());
		System.out.println(driver.findElement(By.xpath("//li[3]")).getText());
		
		
	}
}
