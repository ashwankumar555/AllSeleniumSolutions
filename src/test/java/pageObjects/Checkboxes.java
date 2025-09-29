package pageObjects;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Utils.BaseClass;
import annotations.TestCategory;


public class Checkboxes extends BaseClass {

	WebDriver driver;
	@Test(groups = {"regression"})
	@TestCategory("ui")
	public  void checkboxes() throws IOException {
		Checkboxes cb = new Checkboxes();
		String applicationurl = cb.getConfigProperty("weburl");
		String browserName = cb.getConfigProperty("browser");
		WebDriver driver = cb.getBrowserDriver(browserName);
		CheckboxesPage cbp = new CheckboxesPage(driver);	
		cb.goTo(applicationurl);
		cb.globalimplicitwait(10);
		cbp.selectAllCheckboxes();
		System.out.println("Checkbox count: " +cbp.getCheckboxesCount());
		cb.tearDown();
			}
}
