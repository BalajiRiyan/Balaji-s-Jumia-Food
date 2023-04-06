package com.jumia.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserMyordersPage {
	@FindBy (xpath = "//a[@href='delete_orders.php?order_del=538']")
	private WebElement deletebtn; 
	
	@FindBy (linkText = "Logout")
	private WebElement logoutbtn;

	public UserMyordersPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getDeletebtn() {
		return deletebtn;
	}

	public WebElement getLogoutbtn() {
		return logoutbtn;
	}
	
	public void deleteOrder()
	{
		deletebtn.click();
	}
	public void logout()
	{
		logoutbtn.click();
	}
	
}


