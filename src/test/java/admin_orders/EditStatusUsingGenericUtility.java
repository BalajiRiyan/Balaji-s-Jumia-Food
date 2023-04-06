package admin_orders;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.genericutilities.FileUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
public class EditStatusUsingGenericUtility {

	public static void main(String[] args) throws IOException {
		FileUtility fu = new FileUtility();
		String url = fu.readDataFromPropertyFile("adminurl");
		String un = fu.readDataFromPropertyFile("adminusername");
		String pwd = fu.readDataFromPropertyFile("adminpassword");
		
		WebDriverManager.chromedriver().create();
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("codeastro");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//span[.='Orders']")).click();
	}

}
