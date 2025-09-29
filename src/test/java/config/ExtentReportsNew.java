package config;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsNew {
	
	public static ExtentReports getReportObject()
	{
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Test Results");
        //reporter.config().setTheme(null);

        ExtentReports extent = new ExtentReports();
       
        extent.setSystemInfo("Tester", "Akhira");

        return extent;

	}

}

