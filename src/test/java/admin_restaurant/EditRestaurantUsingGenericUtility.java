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
import com.genericutilities.WebDriverUtiity;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditRestaurantUsingGenericUtility {

	public static void main(String[] args) throws IOException {
		FileUtility fu = new FileUtility();
		String url = fu.readDataFromPropertyFile("adminurl");
		String un = fu.readDataFromPropertyFile("adminusername");
		String pwd = fu.readDataFromPropertyFile("adminpassword");
		
		ExcelUtility Eu = new ExcelUtility();
		HashMap<String, String> map = Eu.readMultipleDataFromExcel("Jumia");
		
		WebDriverManager.chromedriver().create();
		WebDriver driver = new ChromeDriver();
		
		WebDriverUtiity wu = new WebDriverUtiity();
		wu.maximizeWindow(driver);
		wu.implicitwait(driver);
		driver.get(url);
		driver.findElement(By.name("username")).sendKeys(un);
		driver.findElement(By.name("password")).sendKeys(pwd);
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//span[text()='Restaurant']")).click();
		driver.findElement(By.linkText("All Restaurant")).click();
		driver.findElement(By.xpath("//tbody/tr[1]/td[2]/following-sibling::td[10]/a[2]")).click();
		for(Entry<String, String> set:map.entrySet()) 
		{
			if(set.getKey().contains("res_name"))
			{
				WebElement data = driver.findElement(By.name(set.getKey()));
				data.clear();
				driver.findElement(By.name(set.getKey())).sendKeys("Namaste Updated");
			}
			else
			{
				WebElement data = driver.findElement(By.name(set.getKey()));
				data.clear();
				driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());	
			}
		}
		WebElement opendays = driver.findElement(By.name("o_days"));
		wu.select("24hr-x7", opendays);
		WebElement openhours = driver.findElement(By.name("o_hr"));
		wu.select("10am", openhours);
		WebElement closehours = driver.findElement(By.name("c_hr"));
		wu.select("8pm", closehours);
		WebElement category = driver.findElement(By.name("c_name"));
		wu.select("Indian", category);
		File f = new File("./src/test/resources/Biriyani.png");
		String path = f.getAbsolutePath();
		driver.findElement(By.name("file")).sendKeys(path);
		driver.findElement(By.name("submit")).click();
		boolean updated = driver.findElement(By.xpath("//strong[.='Record Updated!']")).isDisplayed();
		if(updated==true)
		{
			System.out.println("Restaurant Updated");
		}
		else
		{
			System.out.println("Restaurant Not Updated");
		}
	}
}
