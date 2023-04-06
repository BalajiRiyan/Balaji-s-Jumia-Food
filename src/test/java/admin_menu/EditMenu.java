package admin_menu;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditMenu {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().create();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://rmgtestingserver/domain/Online_Food_Ordering_System/admin/index.php");
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("codeastro");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//span[.='Menu']")).click();
		driver.findElement(By.xpath("//a[.='All Menues']")).click();
		driver.findElement(By.xpath("//tbody/tr[last()]/td[6]/a[2]")).click();
		WebElement dishname = driver.findElement(By.name("d_name"));
		dishname.clear();
		dishname.sendKeys("Mutton Biriyani");
		Thread.sleep(1000);
		WebElement price = driver.findElement(By.name("price"));
		price.clear();
		price.sendKeys("250");
		Thread.sleep(1000);
		WebElement about = driver.findElement(By.name("about"));
		about.clear();
		about.sendKeys("Eat or else Go");
		Thread.sleep(2000);
		File f = new File("‪./src/test/resources/Biriyani.png");
		String path = f.getAbsolutePath();
		driver.findElement(By.id("lastName")).sendKeys(path);
		WebElement category = driver.findElement(By.name("res_name"));
		Select s = new Select(category);
		Thread.sleep(1000);
		s.selectByVisibleText("Biriyani Hut");
		driver.findElement(By.name("submit")).click();
		Thread.sleep(1000);
		boolean updated = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible fade show']")).isDisplayed();

		if (updated==true) {
			System.out.println("Record updated");
		}
		else {
			System.out.println("Record not updated"); 
		}
	}

}
