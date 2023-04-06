package practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RmgyantraCreateProject {

	public static void main(String[] args) throws IOException, SQLException {
		Connection con =null;
		String expectedproject = "Projectjumia25";
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\rmgyantra.properties");
		Properties p = new Properties();
		p.load(fis);
		String url = p.getProperty("url");
		String un = p.getProperty("username");
		String pwd = p.getProperty("password");

		FileInputStream fiss = new FileInputStream(".\\src\\test\\resources\\rmgyantracreateprojectdatas.xlsx");
		Workbook wb = WorkbookFactory.create(fiss);
		Sheet sh = wb.getSheet("project");

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Random ran = new  Random();
		 int random = ran.nextInt(50);

		driver.get(url);
		driver.findElement(By.name("username")).sendKeys(un);
		driver.findElement(By.name("password")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();


		HashMap<String, String> map = new HashMap<String, String>();
		for (int i = 0; i <= sh.getLastRowNum(); i++) {
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);

		}
		for (Entry<String, String> set : map.entrySet()) {
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue()+random);

		}
		WebElement status = driver.findElement(By.name("status"));
		Select s = new Select(status);
		s.selectByVisibleText("On Gogin");

		driver.findElement(By.xpath("//input[@value = 'Add Project']")).click();

		Driver dr = new Driver();
		DriverManager.registerDriver(dr);
		con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
		Statement state = con.createStatement();
		String query = "select * from project";
		ResultSet result = state.executeQuery(query);
		
		
		boolean flag = false;
		while(result.next()) {
			String actualproject = result.getString(4);
			System.out.println(actualproject);
			if(actualproject.equalsIgnoreCase(expectedproject)) {
				flag = true;
				break;
			}
			if(flag) {
				System.out.println("Project is Created");
			}
			else {
				System.out.println("Project is not Created");
			}
			
		}
		con.close();
	}
}
