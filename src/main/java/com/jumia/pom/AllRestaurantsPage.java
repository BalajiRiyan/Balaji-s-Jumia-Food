package com.jumia.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllRestaurantsPage {
	@FindBy (xpath = "//a[@href ='update_restaurant.php?res_upd=281']")
	private WebElement updatebtn;
	@FindBy (xpath = "//a[@href='delete_restaurant.php?res_del=281']")
	private WebElement deletebtn;
	
	public AllRestaurantsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getUpdatebtn() {
		return updatebtn;
	}

	public WebElement getDeletebtn() {
		return deletebtn;
	}
	
	public void updateRestaurant()
	{
		updatebtn.click();
	}
	public void deleteRestaurant()
	{
		deletebtn.click();
	}

}
