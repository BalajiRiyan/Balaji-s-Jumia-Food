package admin_orders;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditStatus {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().create();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://rmgtestingserver/domain/Online_Food_Ordering_System/admin/");
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("codeastro");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//span[.='Orders']")).click();
		driver.findElement(By.xpath("//tbody/tr[1]/td[8]/a[2]")).click();
		driver.findElement(By.xpath("//button[text()='Update Order Status']")).click();
		 Set<String> allwh = driver.getWindowHandles();
		for(String wh :allwh ) {
        driver.switchTo().window(wh);
		}
		driver.findElement(By.name("username")).sendKeys("Balaji");
		driver.findElement(By.name("password")).sendKeys("Binubala*95");
		driver.findElement(By.name("submit")).click();
		driver.close();
		Set<String> allwh1 = driver.getWindowHandles();
		for(String wh1 :allwh1 ) {
			driver.switchTo().window(wh1);
		}
		driver.findElement(By.xpath("//button[text()='Update Order Status']")).click();
		Set<String> allwh2 = driver.getWindowHandles();
		for(String wh1 :allwh2 ) {
			driver.switchTo().window(wh1);
		}
		WebElement alloption = driver.findElement(By.name("status"));
		Select s = new Select(alloption);
		s.selectByVisibleText("On the way");
		driver.findElement(By.name("remark")).sendKeys(" Go away");
		driver.findElement(By.name("update")).click();
		Alert a = driver.switchTo().alert();
		String Expresult = a.getText();
		System.out.println(Expresult);
		a.accept();
		driver.close();
		Set<String> allwh3 = driver.getWindowHandles();
		for( String wh2 : allwh3) {
			driver.switchTo().window(wh2);
		}
		driver.navigate().refresh();
		if(Expresult.contains("Successfully")) {
			System.out.println("Order Status updated Successfully");
		}
		else {
			System.out.println("Order Status Not updated");
		}
	}

}


