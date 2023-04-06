package user_login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UserLoginPage {

	public static void main(String[] args) {
    WebDriverManager.chromedriver().create();
    WebDriver driver = new ChromeDriver();
    driver.get("http://rmgtestingserver/domain/Online_Food_Ordering_System/login.php");
    driver.findElement(By.name("username")).sendKeys("Balaji");
    driver.findElement(By.name("password")).sendKeys("Binubala*95");
    driver.findElement(By.name("submit")).click();
	}

}
