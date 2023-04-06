package user_myorders;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UserPlaceOrder {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().create();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://rmgtestingserver/domain/Online_Food_Ordering_System/login.php");
		driver.findElement(By.name("username")).sendKeys("Balaji");
		driver.findElement(By.name("password")).sendKeys("Binubala*95");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//a[@href='restaurants.php']")).click();
		driver.findElement(By.xpath("//a[.='View Menu']")).click();
		WebElement myorder = driver.findElement(By.xpath("//a[.='Crispy Chicken Strips']"));
		String expectedorder = myorder.getText();
		System.out.println(expectedorder);
		myorder.click();
		
		driver.findElement(By.xpath("//a[.='Crispy Chicken Strips']/../../../../following-sibling::div//input[2]")).click();
		driver.findElement(By.xpath("//a[.='Checkout']")).click();
		driver.findElement(By.name("submit")).click();
		
		Alert a = driver.switchTo().alert();
		a.accept();
		Alert a1 = driver.switchTo().alert();
		a1.accept();
		Thread.sleep(2000);
		WebElement data = driver.findElement(By.xpath("//tbody/tr[last()]"));
		String actualorder = data.getText();
		System.out.println(actualorder);
		if(actualorder.contains(expectedorder)) {
			System.out.println("Order is placed");
		}
		else {
			System.out.println("Order is not placed");
		}
        driver.close();
	}
}

