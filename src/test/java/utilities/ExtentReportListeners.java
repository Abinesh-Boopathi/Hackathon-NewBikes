package utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportListeners implements ITestListener {
	
	public ExtentSparkReporter spark;         //To Create a UI
	public ExtentReports extent;             //To populate common info
	public ExtentTest test;                  //To create test entries
	String reportName;
	
	public void onStart(ITestContext context) {
		
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		reportName = "TestNG_ExtentReport"+timeStamp+".html";

		String filepath = System.getProperty("user.dir") + "/Reports/ExtentReports/";
		spark = new ExtentSparkReporter(filepath + reportName);
		
		spark.config().setDocumentTitle("ZigWheels-Website");
		spark.config().setReportName("Identify New Bikes & Used Cars");
		spark.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(spark);
		
		//Setting Common Info
		extent.setSystemInfo("Website","ZigWheels");
		extent.setSystemInfo("Module","New Bikes");
		extent.setSystemInfo("Environment","QA");
		extent.setSystemInfo("Tester Name", System.getProperty("user.name"));
		extent.setSystemInfo("Operating System (OS)", System.getProperty("os.name"));
		String browser=context.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);
		
		List<String> includedGroups = context.getCurrentXmlTest().getIncludedGroups();
		if(!includedGroups.isEmpty()) {
		extent.setSystemInfo("Groups", includedGroups.toString());
		}		
		
		
	}
	
	public void onTestSuccess(ITestResult result) {
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups()); //to display groups in report
		test.log(Status.PASS,"Test Passed -- "+ result.getName());
	}
	public void onTestFailure(ITestResult result) {
		test=extent.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL,"Test Failed");
		test.log(Status.INFO,result.getThrowable().getMessage());
		
		String imgpath=new BaseClass().captureScreenonFailure(result.getName());
		test.addScreenCaptureFromPath(imgpath);
		
	}
	public void onTestSkipped(ITestResult result){
		test=extent.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP,"Test Skipped");
		test.log(Status.INFO,result.getThrowable().getMessage());
		
		
		
	}
	
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
