package com.jumia.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericutilities.WebDriverUtiity;

public class HomepageAfterLogin {
	
	//Declaration
	
	@FindBy(xpath = "(//a[@class = 'nav-link active'])[1]")
	private WebElement Home;
	@FindBy(xpath ="(//a[@class = 'nav-link active'])[2]")
	private WebElement Restaurant;
	@FindBy(xpath ="(//a[@class = 'nav-link active'])[3]")
	private WebElement Myorders;
	@FindBy(xpath ="(//a[@class = 'nav-link active'])[4]")
	private WebElement Logout;
	
	//Initialization
	public HomepageAfterLogin(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getHome() {
		return Home;
	}

	public WebElement getRestaurant() {
		return Restaurant;
	}

	public WebElement getMyorders() {
		return Myorders;
	}

	public WebElement getLogout() {
		return Logout;
	}
	
	//BusinessLogic
	public void clickHome()
	{
		Home.click();
	}
	public void clickRestaurant()
	{
		Restaurant.click();
	}
	public void clickMyorders()
	{
		Myorders.click();
	}
	public void clickLogout()
	{
		Logout.click();
	}
	
}
