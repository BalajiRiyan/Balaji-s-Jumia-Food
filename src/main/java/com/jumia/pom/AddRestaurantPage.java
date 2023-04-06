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

public class AddRestaurantPage {
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
	
    public AddRestaurantPage(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
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
    
    public void addRestaurant(WebDriverUtiity wdu, ExcelUtility eu,JavaUtility ju ,WebDriver driver) throws EncryptedDocumentException, IOException
    {
    	 HashMap<String, String> map = eu.readMultipleDataFromExcel("Jumia");
    	 for(Entry<String, String> set:map.entrySet())
    	 {
    		 if(set.getKey().contains("res_name"))
    		 {
    			 driver.findElement(By.name(set.getKey())).sendKeys(set.getValue()+ju.random());
    		 }
    		 else
    		 {
    			 driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
    		 }
    	 }
    	 wdu.select("24hr-x7", opendays);
    	 wdu.select("10am", openhours);
    	 wdu.select("10pm", closehours);
    	 wdu.select("Indian Veg", category);
    	
    	 File f = new File("./src/test/resources/Biriyani.png");
 		 String path = f.getAbsolutePath();
 		 driver.findElement(By.name("file")).sendKeys(path);
 		 submitbtn.click();
 		 String expresult = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible fade show']")).getText();
		 System.out.println(expresult);
		 
		
		
    	
    }
    
    
    
}