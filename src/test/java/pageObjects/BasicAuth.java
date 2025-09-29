package pageObjects;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import Utils.BaseClass;

public class BasicAuth extends BaseClass {
		static WebDriver driver;
		public static void main(String[] args) throws IOException {
			BasicAuth ba = new BasicAuth();
			String browserName = ba.getConfigProperty("browser");
			String url = ba.getConfigProperty("basicauthurl");
			WebDriver driver = ba.getBrowserDriver(browserName);
			ba.goTo(url);
			driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
			ba.globalimplicitwait(3);
			//Alert alert = driver.switchTo().alert();
			//alert.accept();
	}

}
