package com.genericutilities;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener{
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		//Execution Starts from Here
		String Methodname = result.getMethod().getMethodName();
		test = report.createTest(Methodname);
		Reporter.log(Methodname+"----->TestScript Execution Started");
		
	}

	public void onTestSuccess(ITestResult result) {
		String Methodname = result.getMethod().getMethodName();
		test.log(Status.PASS, Methodname+"----->Passed");
		Reporter.log(Methodname+"----->TestScript Execution Sucessful");
	}

	public void onTestFailure(ITestResult result) {
		
		String fscript = result.getMethod().getMethodName();
		String fs = fscript+ new JavaUtility().getSystemDate();
		EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.sdriver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
		File dst = new File("./Screenshot/"+fs+".png");
		File path = dst.getAbsoluteFile();
		try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*try {
			String screenshotname = WebDriverUtiity.getScreenShot(BaseClass.sdriver, result.getMethod().getMethodName());
			test.addScreenCaptureFromPath(screenshotname);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		test.log(Status.FAIL, result.getThrowable());
		Reporter.log("TestScript Execution Failed");
		
	}

	public void onTestSkipped(ITestResult result) {
		String Methodname = result.getMethod().getMethodName();
		test.log(Status.SKIP, Methodname+"---->Skipped");
		test.log(Status.SKIP,result.getThrowable());
		Reporter.log("TestScript Execution Skipped");
	}

	public void onStart(ITestContext context) {
		//create html report
		ExtentSparkReporter htmlreport = new ExtentSparkReporter("./Extentreport/report.html");
		htmlreport.config().setDocumentTitle("online Food ordering Project");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("Jumia Food");
		
		report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base_Browser", "chrome");
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Base_URL", "http://rmgtestingserver/domain/Online_Food_Ordering_System/admin/");
		report.setSystemInfo("Reporter Name", "Balaji");
	}

	public void onFinish(ITestContext context) {
		//consolidate the report
		report.flush();
		
	}
	

}
