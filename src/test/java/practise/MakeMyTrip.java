package practise;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTrip {

	public static void main(String[] args) {
     WebDriver driver = WebDriverManager.chromedriver().create();
     driver.get("https://www.makemytrip.com/");
     driver.findElement(null);
	}
	

}
