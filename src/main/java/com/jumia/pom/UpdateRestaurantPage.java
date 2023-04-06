package com.jumia.pom;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericutilities.ExcelUtility;
import com.genericutilities.JavaUtility;
import com.genericutilities.WebDriverUtiity;

public class UpdateRestaurantPage {
	@FindBy (name = "o_days")
	private WebElement opendays;
	@FindBy (name = "o_hr")
	private WebElement openhours;
	@FindBy (name = "c_hr")
	private WebElement closehours;
	@FindBy (name = "c_name")
	private WebElement category;
	@FindBy (name = "file")
	private WebElement image;
	@FindBy (name = "submit")
	private WebElement submitbtn;
	
	public UpdateRestaurantPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	 public WebElement getOpendays() {
		return opendays;
	}

	public WebElement getOpenhours() {
		return openhours;
	}

	public WebElement getClosehours() {
		return closehours;
	}

	public WebElement getCategory() {
		return category;
	}

	public WebElement getImage() {
		return image;
	}

	public WebElement getSubmitbtn() {
		return submitbtn;
	}

	public void updateRestaurant(WebDriverUtiity wdu, ExcelUtility eu,JavaUtility ju ,WebDriver driver) throws EncryptedDocumentException, IOException
	{
		ExcelUtility Eu = new ExcelUtility();
		HashMap<String, String> map = Eu.readMultipleDataFromExcel("UpdateRestaurant");
		for(Entry<String, String> set:map.entrySet()) 
		{
			if(set.getKey().contains("res_name"))
			{
				WebElement data = driver.findElement(By.name(set.getKey()));
				data.clear();
				driver.findElement(By.name(set.getKey())).sendKeys(set.getValue()+ju.random());
			}
			else
			{
				WebElement data = driver.findElement(By.name(set.getKey()));
				data.clear();
				driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());	
			}
		}
		WebElement opendays = driver.findElement(By.name("o_days"));
		wdu.select("24hr-x7", opendays);
		WebElement openhours = driver.findElement(By.name("o_hr"));
		wdu.select("10am", openhours);
		WebElement closehours = driver.findElement(By.name("c_hr"));
		wdu.select("8pm", closehours);
		WebElement category = driver.findElement(By.name("c_name"));
		wdu.select("Indian", category);
		File f = new File("./src/test/resources/Biriyani.png");
		String path = f.getAbsolutePath();
		driver.findElement(By.name("file")).sendKeys(path);
		driver.findElement(By.name("submit")).click();
		boolean updated = driver.findElement(By.xpath("//strong[.='Record Updated!']")).isDisplayed();
		if(updated==true)
		{
			System.out.println("Restaurant Updated");
		}
		else
		{
			System.out.println("Restaurant Not Updated");
		}
	    }

}
