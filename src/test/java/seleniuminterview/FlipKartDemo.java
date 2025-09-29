package seleniuminterview;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipKartDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']")).sendKeys("tv");
        Thread.sleep(3000);
        List<WebElement> searchResults = driver.findElements(By.xpath("//a[@class='oleBil']"));
        
        searchResults.forEach(item -> System.out.println("Searchmenu: " + item.getText()));
        
        driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']"))
        .sendKeys(Keys.ESCAPE);

        //System.out.println(driver.findElement(By.xpath("//ul[@class='_1sFryS']/li[2]")).getText());
     // Close login popup
        try {
            WebElement closeLogin = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'✕')]"))
            );
            closeLogin.click();
        } catch (Exception e) {
            System.out.println("Login popup not displayed.");
        }

        // Locate Fashion menu
        WebElement fashion = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//span[text()='Fashion']")));
        System.out.println("Main Menu: " + fashion.getText());

        // Hover over Fashion
        Actions actions = new Actions(driver);
        actions.moveToElement(fashion).perform();
        Thread.sleep(1000);

        // Wait for submenu
        List<WebElement> subItems = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(
                       By.xpath("//a[@class='_1BJVlg']")
                		//By.xpath("//div[@class='Q8LFtc']//a") 
                )
        );

        // Print submenu
        for (WebElement item : subItems) {
            System.out.println("Submenu: " + item.getText());
        }
        
        WebElement innerMenu = subItems.stream()
                .filter(e -> e.getText().toLowerCase().contains("bottom wear"))
                .findFirst()
                .orElseThrow();
        actions.moveToElement(innerMenu).perform();
        System.out.println("Hovered on: " + innerMenu.getText());

        // Get second-level submenu items
        List<WebElement> subItemsInner = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(
                        By.xpath("//a[@class='_3490ry']")
                )
        );
        for (WebElement item : subItemsInner) {
            System.out.println("Inner Submenu: " + item.getText());           
        }      
        driver.findElement(By.xpath("(//a[@class='_3490ry'])[3]")).click();
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");
        
        //driver.findElement(By.cssSelector(".fxf7w6.rgHxCQ")).click();
        //driver.findElement(By.xpath("//div[@class='_6i1qKy' and text()='Raymond']")).click();
        //Thread.sleep(1000);
        //String brand = driver.findElement(By.cssSelector("._6tw8ju")).getText().trim();       
        //Assert.assertTrue(brand.contains("Raymond"), "Expected text to contain Raymond but got: " + brand);
        
        //Mouse over
        //WebElement loginlist = driver.findElement(By.xpath("//a[@class='wsejfv']"));
        //Actions a = new Actions(driver);
        //a.moveToElement(loginlist).build().perform();
        
        //Assigning all webelements to a List and print the values from list using streams()
        //List<WebElement> login = driver.findElements(By.cssSelector(".B7XK2X.dpQ-wM"));   
        //login.stream().forEach(s->System.out.println(s.getText()));
        
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[local-name()='svg'][contains(@class, 'ukzDZP')]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@placeholder='Search Brand']")).sendKeys("road");
        List<WebElement> search = driver.findElements(By.cssSelector(".ewzVkT"));   
        search.stream().filter(s->s.getText().contains("Road")).forEach(s->System.out.println(s.getText()));
        
        driver.quit();
    }
}
