package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Utils.BaseClass;
import annotations.TestCategory;


public class AddRemoveElements extends BaseClass {
	
	
	static WebDriver driver;
	@Test(groups = {"regression"})
	@TestCategory("ui")
	public  void addremove() throws IOException {
		AddRemoveElements are = new AddRemoveElements();
		String browserName = are.getConfigProperty("browser");
		String url = are.getConfigProperty("removeelementsurl");
		WebDriver driver = are.getBrowserDriver(browserName);
		AddRemoveElementsPage arep = new AddRemoveElementsPage(driver);
		arep.goTo(url);
		are.globalimplicitwait(5);	
		arep.selectElements(5);
		are.globalimplicitwait(2);
		arep.removeElements(5);
	}
}
