package com.jumia.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericutilities.WebDriverUtiity;

public class AdminOrdersPage {
	@FindBy (xpath = "//tbody/tr[1]/td[1]/following-sibling::td[7]/a[1]")
	private WebElement deletebtn;
	
	@FindBy (xpath = "//tbody/tr[1]/td[1]/following-sibling::td[7]/a[2]")
	private WebElement editebtn;
	
	public void AdminOrderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getDeletebtn() {
		return deletebtn;
	}

	public WebElement getEditebtn() {
		return editebtn;
	}
	
	public void deleteOrder(WebDriverUtiity wdu, WebDriver driver)
	{
		deletebtn.click();
		wdu.acceptAlert(driver);
	}
	public void editOrder()
	{
		editebtn.click();
	}

}
