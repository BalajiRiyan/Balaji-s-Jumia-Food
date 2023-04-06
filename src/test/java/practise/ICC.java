package practise;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ICC {

	public static void main(String[] args) {
      WebDriver driver = WebDriverManager.chromedriver().create();
      driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
     List<WebElement> pos = driver.findElements(By.xpath("//tbody/tr/td[1]"));
     List<WebElement> team = driver.findElements(By.xpath("//tbody/tr/td[2]"));
     List<WebElement> matches = driver.findElements(By.xpath("//tbody/tr/td[3]"));
     List<WebElement> points = driver.findElements(By.xpath("//tbody/tr/td[4]"));
     List<WebElement> ratings = driver.findElements(By.xpath("//tbody/tr/td[5]"));
     int co = pos.size();
     for (int i = 0; i < co; i++) {
    	 System.out.println(pos.get(i).getText()+ " "+team.get(i).getText()+" "+matches.get(i).getText()+ " "+points.get(i).getText()+ " "+ratings.get(i).getText());
		
	}
	}

}
