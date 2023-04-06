package user_myorders;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.genericutilities.FileUtility;
import com.genericutilities.WebDriverUtiity;
import com.jumia.pom.HomepageAfterLogin;
import com.jumia.pom.HomepageBeforeLogin;
import com.jumia.pom.Loginpage;
import com.jumia.pom.RestaurantPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PlaceOrderTest
{
	public static void main(String[] args) throws IOException 
	{
		FileUtility fu = new FileUtility();
		String url = fu.readDataFromPropertyFile("userurl");
		String un = fu.readDataFromPropertyFile("userusername");
		String pwd = fu.readDataFromPropertyFile("userpassword");
		
		WebDriverUtiity wdu = new  WebDriverUtiity();
		
		
		WebDriverManager.chromedriver().create();
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		wdu.implicitwait(driver);
		wdu.maximizeWindow(driver);

		HomepageBeforeLogin hb = new HomepageBeforeLogin(driver);
		hb.clickLogin();
		Loginpage l = new Loginpage(driver);
		l.setLogin(un, pwd);
		HomepageAfterLogin ha = new HomepageAfterLogin(driver);
		ha.clickRestaurant();
		RestaurantPage rp = new RestaurantPage(driver);
		rp.placeOrder(wdu, driver);
		
	}

}
