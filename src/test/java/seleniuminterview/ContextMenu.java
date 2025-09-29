package seleniuminterview;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextMenu {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/context_menu");
        Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(By.xpath("//div[@oncontextmenu='displayMessage()']")));
        a.contextClick().perform();
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert says: " + alert.getText());
        alert.accept();
	}
}
