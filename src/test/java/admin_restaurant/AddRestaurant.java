package admin_restaurant;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.genericutilities.ExcelUtility;
import com.genericutilities.FileUtility;
import com.genericutilities.JavaUtility;
import com.genericutilities.WebDriverUtiity;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddRestaurant {
public static void main(String[] args) throws IOException {
		
		FileUtility fu = new FileUtility();
		String url = fu.readDataFromPropertyFile("url");
		String un = fu.readDataFromPropertyFile("username");
		String pwd = fu.readDataFromPropertyFile("password");
		
		JavaUtility jv = new JavaUtility();
		int random = jv.random();
		
		
		ExcelUtility eu = new ExcelUtility();
		HashMap<String, String> map = eu.readMultipleDataFromExcel("Jumia");
		
		WebDriverManager.chromedriver().create();
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		
		WebDriverUtiity wdu = new WebDriverUtiity();
		wdu.maximizeWindow(driver);
		wdu.implicitwait(driver);
		
		
		driver.findElement(By.name("username")).sendKeys(un);
		driver.findElement(By.name("password")).sendKeys(pwd);
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//span[text()='Restaurant']")).click();
		driver.findElement(By.linkText("Add Restaurant")).click();
		
		for(Entry<String, String> set:map.entrySet()) 
		{
			if(set.getKey().contains("res_name"))
			{
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue()+random);
			}
			else
			{
				driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());	
			}
		    }
		WebElement opendays = driver.findElement(By.name("o_days"));
		wdu.select("24hr-x7", opendays);
		WebElement openhours = driver.findElement(By.name("o_hr"));
		wdu.select("10am", openhours);
		WebElement closehours = driver.findElement(By.name("c_hr"));
		wdu.select("10pm", closehours);
		WebElement category = driver.findElement(By.name("c_name"));
		wdu.select("Indian", category);
		File f = new File("./src/test/resources/Biriyani.png");
		String path = f.getAbsolutePath();
		driver.findElement(By.name("file")).sendKeys(path);
		driver.findElement(By.name("submit")).click();
		String expresult = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible fade show']")).getText();
		System.out.println(expresult);

	}
}

