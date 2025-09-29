package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckboxesPage {
	WebDriver driver;
	
	// Constructor → initializes driver and elements
	public CheckboxesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); 
    }
	
	@FindBy(xpath="//input[@type='checkbox']")
	List<WebElement> list;
	
	
	public int getCheckboxesCount()
	{
		return list.size();
	}
	
	
	public void selectAllCheckboxes() {
        for (WebElement checkbox : list) {
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }
    }
	
	public void tearDown()
	{
		driver.quit();
	}
}
