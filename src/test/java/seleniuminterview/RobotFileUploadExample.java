package seleniuminterview;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.MultiResolutionImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class RobotFileUploadExample {
    public static void main(String[] args) throws Exception {

        // Set path for ChromeDriver if not in system PATH
        //System.setProperty("webdriver.chrome.driver", "C:\\path\\to\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open a demo site with upload button
        driver.get("https://www.file.io/"); // or any upload demo site
        
        Thread.sleep(2000);
        // Click on the upload button to open the native file dialog
        driver.findElement(By.xpath("//label[@for='select-files-input']")).click();

        // Give some time for dialog to appear
        Thread.sleep(2000);

        // Path of file to upload
        String filePath = "C:\\Users\\user\\Test_data.xlsx";
        
      
        // Copy the file path to clipboard
        StringSelection selection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

        // Create Robot instance
        Robot robot = new Robot();
        robot.setAutoDelay(500);
        
        
        //robot.createMultiResolutionScreenCapture();

        // Press CTRL+V (paste the path)
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        // Press ENTER
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        // Wait a bit to see upload happen
        Thread.sleep(3000);

        System.out.println("File uploaded successfully using Robot class!");
        
        Rectangle screenRect = new Rectangle(0, 0, 500, 400);

        // Take screenshot
        MultiResolutionImage multiImg = robot.createMultiResolutionScreenCapture(screenRect);

        // Get the highest resolution variant from MultiResolutionImage
        BufferedImage img = (BufferedImage) multiImg.getResolutionVariant(500, 400);

        // Save it as a PNG
        
        File outputFile = new File("C:\\Users\\user\\Screenshots\\screenshot.png");
        ImageIO.write(img, "png", outputFile);

        System.out.println("Screenshot saved as screenshot.png");

        //driver.quit();
    }
}
