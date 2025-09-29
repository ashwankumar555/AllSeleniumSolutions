package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.BaseClass;

public class AddRemoveElementsPage extends BaseClass {
	WebDriver driver;
	
	// Constructor → initializes driver and elements
	public AddRemoveElementsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); 
    }
	
	@FindBy(xpath="//button[@onclick='addElement()']")
	WebElement element;
	
	public void goTo(String url)
	{
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	
	
	public void selectElements(int itemscount) {
		
		for(int i=1; i<=itemscount; i++)
		{
			element.click();
		}        
    }
	
	public void removeElements(int itemscount) {
		
		for(int j=itemscount; j>0; j--)
		{
		driver.findElement(By.xpath("//div[@id='elements']//button[" + j + "]")).click();
		}        
    }
	
}
