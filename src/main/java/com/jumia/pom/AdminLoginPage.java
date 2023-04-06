package com.jumia.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage {
	@FindBy(name = "username")
	private WebElement  untbx;
	@FindBy(name = "password")
	private WebElement pwtbx;
	@FindBy(name = "submit")
	private WebElement lgbtn;
	
	public AdminLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public void setLogin(String un,String pw)
	{
		untbx.sendKeys(un);
		pwtbx.sendKeys(pw);
		lgbtn.click();
	}
	

}
