package admin_restaurant;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.genericutilities.ExcelUtility;
import com.genericutilities.FileUtility;
import com.genericutilities.JavaUtility;
import com.genericutilities.WebDriverUtiity;
import com.jumia.pom.AddRestaurantPage;
import com.jumia.pom.AdminLoginPage;
import com.jumia.pom.AdminpanelPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddRestaurantTest {

	public static void main(String[] args) throws IOException {

		FileUtility fu = new FileUtility();
		String url = fu.readDataFromPropertyFile("adminurl");
		String un = fu.readDataFromPropertyFile("adminusername");
		String pwd = fu.readDataFromPropertyFile("adminpassword");
		
		WebDriverManager.chromedriver().create();
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		
		WebDriverUtiity wdu = new  WebDriverUtiity();
		wdu.implicitwait(driver);
		wdu.maximizeWindow(driver);
		
		ExcelUtility eu = new ExcelUtility();
		JavaUtility ju = new JavaUtility();
		
		AdminLoginPage al = new AdminLoginPage(driver);
		al.setLogin(un, pwd);
		
		AdminpanelPage ap = new AdminpanelPage(driver);
		ap.clickAddRestaurantmodule();
		
		AddRestaurantPage arp = new AddRestaurantPage(driver);
		arp.addRestaurant(wdu, eu, ju, driver);
		ap.logout();
		

	}

}
