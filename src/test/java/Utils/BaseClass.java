package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

public class BaseClass {
	WebDriver driver;
	public String getConfigProperty(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\user\\eclipse-workspace\\coreJavaLearning\\src\\test\\java\\config\\config.properties");
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(key);	
	}
	
	public void goTo(String url)
	{
		driver.get(url);
		driver.manage().window().maximize();
	}
	public void globalimplicitwait(int i)
	{
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(i));
	}
	public WebDriver getBrowserDriver(String browserName)
	
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			//options.addArguments("--headless");
			options.addArguments("--incognito");
			
			driver = new ChromeDriver(options);
			//return drivername;
		}
		return driver;
	}
	
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+"//reports//"+ testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}
