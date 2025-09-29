package seleniuminterview;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/drag_and_drop");
		WebElement draggable = driver.findElement(By.xpath("//div[@id='column-a']"));
		WebElement droppable = driver.findElement(By.xpath("//div[@id='column-b']"));
		Actions a = new Actions(driver);
		a.dragAndDrop(draggable, droppable).perform();
	}
}
