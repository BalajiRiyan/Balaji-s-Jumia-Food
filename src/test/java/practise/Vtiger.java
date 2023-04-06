package practise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Vtiger {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().create();
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
	}

}
