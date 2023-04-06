package admin_menu;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.genericutilities.ExcelUtility;
import com.genericutilities.FileUtility;
import com.genericutilities.WebDriverUtiity;
import com.jumia.pom.AddMenuPage;
import com.jumia.pom.AdminLoginPage;
import com.jumia.pom.AdminpanelPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddMenuTest {

	public static void main(String[] args) throws IOException {
		FileUtility fu = new FileUtility();
		String url = fu.readDataFromPropertyFile("adminurl");
		String un = fu.readDataFromPropertyFile("adminusername");
		String pwd = fu.readDataFromPropertyFile("adminpassword");
		
		ExcelUtility eu = new ExcelUtility();
		
		WebDriverManager.chromedriver().create();
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		
		AdminLoginPage al = new AdminLoginPage(driver);
		al.setLogin(un, pwd);
		
		WebDriverUtiity wdu = new  WebDriverUtiity();
		wdu.implicitwait(driver);
		wdu.maximizeWindow(driver);
		AdminpanelPage ap = new AdminpanelPage(driver);
		ap.clickMenumodule();
		ap.clickAddMenumodule();
		AddMenuPage amp = new AddMenuPage(driver);
		amp.AddMenuToRestaurant(eu, driver, wdu);

	}

}
