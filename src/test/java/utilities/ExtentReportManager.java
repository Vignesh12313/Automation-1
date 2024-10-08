package utilities;


import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener{
	
	public ExtentSparkReporter sparkreporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	String repName;
	
	  public void  onStart(ITestContext testcontext)
	{
		
		String timestamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repName= "Test-Report-" + timestamp + ".html";
		
	
		
		sparkreporter = new ExtentSparkReporter(".\\reports\\" + repName);
		
		
		sparkreporter.config().setDocumentTitle("Automation Report");
		sparkreporter.config().setReportName("Functional Testing ");
		sparkreporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkreporter);
		extent.setSystemInfo("Tester Name", "Vicky");
		extent.setSystemInfo("Application", "Digival");
		extent.setSystemInfo("Module", "Entrance Exam ");
		extent.setSystemInfo("Environment ", "QA");
		
		String os = testcontext.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("operating system", os);
		
		String browser = testcontext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("browser", browser);

}
	  public void onTestStart(ITestResult result) {
		    test = extent.createTest(result.getMethod().getMethodName()); // Create a test entry in the report
		}
	
	public void onTestsuccess(ITestResult result)
	{
		test = extent.createTest(result.getTestClass().getName());
		test.log(Status.PASS, result.getName()+" got successfully executed");
		
	}
	
	public void onTestFailure(ITestResult result)
	{
		test = extent.createTest(result.getTestClass().getName());
		test.log(Status.FAIL, result.getName()+" got failed");
		test.log(Status.INFO, result.getThrowable().getMessage());
		
		try {
			String imgpath= new BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgpath);
			
		}  catch (Exception e1)
		{
			e1.printStackTrace();
		}
		
	}
	public void onTestSkipped(ITestResult result) {
	    test = extent.createTest(result.getMethod().getMethodName());
	 
	    test.log(Status.SKIP, "Test skipped: " + result.getName());
	}
	public void onFinish(ITestContext testcontext) {
	    if (extent != null) {
	        extent.flush(); // This ensures the report is saved to the file
	    }
	    
	    String pathofExtentReport= System.getProperty("user.dir")+"\\reports\\"+repName;
	    File extentReport = new File(pathofExtentReport);
	    
	    try {
	    	Desktop.getDesktop().browse(extentReport.toURI());
	    }catch(IOException e) {
	    	e.printStackTrace();
	    }
	}
}
	
