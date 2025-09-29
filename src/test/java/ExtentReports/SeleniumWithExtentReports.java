package ExtentReports;


import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SeleniumWithExtentReports {

    WebDriver driver;
    ExtentReports extent;
    ExtentTest test;
    ExtentSparkReporter htmlReporter;

    @BeforeSuite
    public void setupExtentReport() {
        htmlReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("Selenium Test Report");
        htmlReporter.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        extent.setSystemInfo("Host Name", "Localhost");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User", "Your Name");
    }

    @BeforeMethod
    public void setup() {
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void googleTitleTest() {
        test = extent.createTest("Google Title Test");

        driver.get("https://www.google.com");
        test.log(Status.INFO, "Navigated to Google");

        String title = driver.getTitle();
        test.log(Status.INFO, "Page title is: " + title);

        Assert.assertEquals(title, "Google");
        test.log(Status.PASS, "Title matched");
    }

    @Test
    public void failedTestExample() {
        test = extent.createTest("Intentional Failure Test");

        driver.get("https://www.google.com");
        test.log(Status.INFO, "Navigated to Google");

        String title = driver.getTitle();
        test.log(Status.INFO, "Page title is: " + title);

        // Intentional failure
        Assert.assertEquals(title, "Google");
        test.log(Status.PASS, "Title matched"); // Will be skipped if assertion fails
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "Test Failed: " + result.getName());
            test.log(Status.FAIL, result.getThrowable());

            String screenshotPath = captureScreenshot(result.getName());
            test.addScreenCaptureFromPath(screenshotPath);
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Test Passed: " + result.getName());
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Test Skipped: " + result.getName());
        }

        driver.quit();
    }

    @AfterSuite
    public void tearDownExtent() {
        extent.flush(); // Write everything to report
    }

    public String captureScreenshot(String testName) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String date = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String path = "test-output/screenshots/" + testName + "_" + date + ".png";
        try {
            Files.createDirectories(new File("test-output/screenshots/").toPath());
            File dest = new File(path);
            Files.copy(src.toPath(), dest.toPath());
            return path;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}