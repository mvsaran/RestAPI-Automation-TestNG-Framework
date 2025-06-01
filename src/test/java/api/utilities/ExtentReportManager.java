package api.utilities;
import java.io.File;
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


public class ExtentReportManager implements ITestListener {
	
	public ExtentSparkReporter sparkReporter;//	// ExtentSparkReporter is used to generate the report in HTML format
	public ExtentReports extentReports;//	// ExtentReports is used to create the report object
	public ExtentTest test;//	// ExtentTest is used to create the test object
	
	String reportName;
	
	public void onStart(ITestContext testContext) {
		
		/*SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		Date dt = new Date();
		String currentdatetimestamp = df.format(dt);*/
		
		String timeStamp = new SimpleDateFormat("YYYY.MM.dd.HH.mm.ss").format(new Date());
		reportName = "Test-Report - " + timeStamp	+ ".html";
		sparkReporter = new ExtentSparkReporter(".\\reports\\"+reportName);
		
		sparkReporter.config().setDocumentTitle(" PetStore Automation Report");
		sparkReporter.config().setReportName(" PetStore APITesting  Report");
		sparkReporter.config().setTheme(Theme.DARK);

		extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReporter);
		extentReports.setSystemInfo("OS", "Windows");
		extentReports.setSystemInfo("Browser", "Chrome");
		extentReports.setSystemInfo("Application","PetStore");
		extentReports.setSystemInfo("UserName",System.getProperty("user.name"));
		extentReports.setSystemInfo("Environment","Stage");
		
		String browser = testContext.getCurrentXmlTest().getParameter("browser");
		extentReports.setSystemInfo("Browser", browser);
		
		List<String>includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
		if(includedGroups.isEmpty())
		{
			extentReports.setSystemInfo("Groups", includedGroups.toString());
		}
		
		}
	
	public void onTestSuccess(ITestResult result) {
	    test = extentReports.createTest(result.getMethod().getMethodName());
	    test.assignCategory(result.getMethod().getGroups());
	    test.log(Status.PASS, "Test Case Passed is: " + result.getName());
	}

	public void onTestFailure(ITestResult result) {
	    test = extentReports.createTest(result.getMethod().getMethodName());
	    test.assignCategory(result.getMethod().getGroups());
	    test.log(Status.FAIL, "Test Case Failed is: " + result.getName());
	    test.log(Status.INFO, result.getThrowable().getMessage());

//	    try {
//	        String imagePath = new BaseClass().captureScreen(result.getName());
//	        test.addScreenCaptureFromPath(imagePath);
//	    } catch (IOException e1) {
//	        e1.printStackTrace();
//	    }
	}

	public void onTestSkipped(ITestResult result) {
	    test = extentReports.createTest(result.getMethod().getMethodName());
	    test.assignCategory(result.getMethod().getGroups());
	    test.log(Status.SKIP, result.getName() + " got Skipped");
	    test.log(Status.INFO, result.getThrowable().getMessage());
	}
   
   public void onFinish(ITestContext testContext) {
	   
	  
	   
	   String pathofExtentReport = System.getProperty("user.dir")+"\\reports\\"+reportName;
	   File extentReport =new File(pathofExtentReport);
	   
//	   try {
//		   Desktop.getDesktop().browse(extentReport.toURI());
//	   }catch (IOException e) {
//		   e.printStackTrace();
//	   }
	   extentReports.flush();
   }
}
