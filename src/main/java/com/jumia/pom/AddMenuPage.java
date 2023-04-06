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
import com.genericutilities.WebDriverUtiity;

public class AddMenuPage {
	@FindBy (name = "d_name")
	private WebElement dishname;
	
	@FindBy (name = "about")
	private WebElement about;
	
	@FindBy (name = "price")
	private WebElement price;
	
	@FindBy (name = "file")
	private WebElement image;
	
	@FindBy (name = "res_name")
	private WebElement category;
	
	@FindBy (name = "submit")
	private WebElement submitbtn;
	
	public AddMenuPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getDishname() {
		return dishname;
	}

	public WebElement getAbout() {
		return about;
	}

	public WebElement getPrice() {
		return price;
	}

	public WebElement getImage() {
		return image;
	}

	public WebElement getCategory() {
		return category;
	}

	public WebElement getSubmitbtn() {
		return submitbtn;
	}
	
	public void AddMenuToRestaurant(ExcelUtility eu,WebDriver driver,WebDriverUtiity wdu) throws EncryptedDocumentException, IOException
	{
		HashMap<String, String> map = eu.readMultipleDataFromExcel("AddMenu");
		for(Entry<String, String> set:map.entrySet())
		{
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		}
		
		File f = new File("./src/test/resources/Biriyani.png");
		 String path = f.getAbsolutePath();
		 image.sendKeys(path);
		 
		 wdu.select("Biriyani Hut",category);
		 submitbtn.click();
		 
		 boolean updated = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible fade show']")).isDisplayed();

			if (updated==true) 
			{
				System.out.println("Menu Added Sucessfully");
			}
			else
			{
				System.out.println("Menu not added"); 
			}
	}
	

}
