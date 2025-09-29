package seleniuminterview;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dropdown");
		 WebElement dropdownElement = driver.findElement(By.id("dropdown"));
		 Select dropdown = new Select(dropdownElement);

	        // 1. Print all options in the dropdown
	        System.out.println("All available options:");
	        for (WebElement option : dropdown.getOptions()) {
	            System.out.println(option.getText());
	        }
	}
}
