package seleniuminterview;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownsPractise {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByIndex(3);
		
		List<WebElement> list = dropdown.getOptions();
		list.stream().forEach(s->System.out.println(s.getText()));
		
		
		String str1 = dropdown.getFirstSelectedOption().getText();
		System.out.println(str1);
		Thread.sleep(2000);
		
		dropdown.selectByVisibleText("INR");
		String str2 = dropdown.getFirstSelectedOption().getText();
		System.out.println(str2);
		Thread.sleep(2000);
		dropdown.selectByValue("AED");
		String str3 = dropdown.getFirstSelectedOption().getText();
		System.out.println(str3);
	}
}
