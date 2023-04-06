package com.genericutilities;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.jumia.pom.AdminLoginPage;
import com.jumia.pom.AdminpanelPage;
import com.jumia.pom.HomepageAfterLogin;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public DatabaseUtility db = new DatabaseUtility();
	public FileUtility fu = new FileUtility();
	public ExcelUtility eu = new ExcelUtility();
	public WebDriverUtiity wdu = new WebDriverUtiity();
	public WebDriver driver;
	public static WebDriver sdriver;
	@BeforeSuite(alwaysRun = true)
	public void configBS() throws SQLException
	{
		db.connectToDB();
		Reporter.log("DB Connected",true);
	}
	@BeforeClass(alwaysRun = true)
	public void configBC() throws IOException
	{
		String Browser = fu.readDataFromPropertyFile("browser");
		String url = fu.readDataFromPropertyFile("adminurl");
		if(Browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (Browser.equalsIgnoreCase("edge")) 
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("Invalid Browser");
		}
		sdriver = driver;
		wdu.maximizeWindow(driver);
		wdu.implicitwait(driver);
		driver.get(url);
		Reporter.log("Browser Launched",true);
	}
	@BeforeMethod(alwaysRun = true)
	public void configBM() throws IOException
	{
		String un = fu.readDataFromPropertyFile("adminusername");
		String pwd = fu.readDataFromPropertyFile("adminpassword");
		AdminLoginPage al = new AdminLoginPage(driver);
		al.setLogin(un, pwd);
		Reporter.log("Logged into the Application ",true);
	}
	@AfterMethod(alwaysRun = true)
	public void configAM()
	{
		AdminpanelPage apl = new AdminpanelPage(driver);
		apl.logout();
		Reporter.log("Logged out of the Application ",true);
	}
	@AfterClass(alwaysRun = true)
	public void configAF()
	{
		driver.quit();
		Reporter.log("Browser Closed",true);
	}
	@AfterSuite(alwaysRun = true)
	public void configAS() throws SQLException
	{
		db.closeDB();
		Reporter.log("DB disConnected ",true);
	}

}
