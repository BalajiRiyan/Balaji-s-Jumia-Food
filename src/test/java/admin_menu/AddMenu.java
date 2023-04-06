package admin_menu;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddMenu {

	public static void main(String[] args) throws IOException, InterruptedException {
       FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\addmenudatas.properties");
       Properties p = new Properties();
       p.load(fis);
       String name = p.getProperty("username");
       String pwd = p.getProperty("password");
       String url = p.getProperty("url");
       
       FileInputStream fiss = new FileInputStream(".\\src\\test\\resources\\Addmenudatas.xlsx");
       Workbook wb = WorkbookFactory.create(fiss);
       Sheet sh = wb.getSheet("Menu");
       
      
       WebDriverManager.chromedriver().create();
		WebDriver driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       driver.get(url);
       driver.findElement(By.name("username")).sendKeys(name);
		driver.findElement(By.name("password")).sendKeys(pwd);
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//span[.='Menu']")).click();
		driver.findElement(By.xpath("//a[.='Add Menu']")).click();
		
		HashMap<String, String> map = new HashMap<String, String>();
	       for (int i = 0; i <= sh.getLastRowNum(); i++) {
	    	   String key = sh.getRow(i).getCell(0).getStringCellValue();
	    	   String value = sh.getRow(i).getCell(1).getStringCellValue();
			   map.put(key, value);
		     }
       
       for(Entry<String, String> set : map.entrySet()) {
    	   driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
       }
       
       
       File f = new File(".\\src\\test\\resources\\Biriyani.png");
      String path = f.getAbsolutePath();
      Thread.sleep(1000);
      driver.findElement(By.name("file")).sendKeys(path);
      
      
      WebElement category = driver.findElement(By.name("res_name"));
      Select s = new Select(category);
      s.selectByVisibleText("Biriyani Hut");
      driver.findElement(By.name("submit")).click();
      
      
      boolean menuadded = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible fade show']")).isDisplayed();
      if(menuadded==true) {
    	  System.out.println("Menu added Sucessfully");
      }
      else {
    	  System.out.println("Menu not added");
      }
      driver.close();
	}

}
