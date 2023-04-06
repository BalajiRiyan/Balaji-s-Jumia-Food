package admin_menu;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.genericutilities.ExcelUtility;
import com.genericutilities.FileUtility;
import com.genericutilities.WebDriverUtiity;
import com.jumia.pom.AdminLoginPage;
import com.jumia.pom.AdminpanelPage;
import com.jumia.pom.AllMenuPage;
import com.jumia.pom.UpdateMenuPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UpdateMenuTest {

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
		ap.clickAllMenuesmodule();
		AllMenuPage am = new AllMenuPage(driver);
		am.editmenu();
		UpdateMenuPage ump = new UpdateMenuPage(driver);
		ump.updateMenuToRestaurant(eu, driver, wdu);
		

	}

}
