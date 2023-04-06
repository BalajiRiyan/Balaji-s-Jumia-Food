package practise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TokyoOlymbics {

	public static void main(String[] args) {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
       List<WebElement> team = driver.findElements(By.xpath("//span[@data-cy='country-name']"));
       List<WebElement> gold = driver.findElements(By.xpath("//div[@title='Gold']")); 
       List<WebElement> silver = driver.findElements(By.xpath("//div[@title='Silver']"));
       List<WebElement> bronze = driver.findElements(By.xpath("//div[@title='Bronze']"));
       List<WebElement> total = driver.findElements(By.xpath("//span[@data-cy='country-name']/../following-sibling::div[4]"));
       int count = team.size();
       for (int i = 0; i < count; i++) {
    	   System.out.println(team.get(i).getText()+" "+gold.get(i).getText()+" "+silver.get(i).getText()+" "+bronze.get(i).getText()+" "+total.get(i).getText());	
	}
       driver.close();
       
	}

}
