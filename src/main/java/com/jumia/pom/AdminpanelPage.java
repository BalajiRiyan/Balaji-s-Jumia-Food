package com.jumia.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericutilities.WebDriverUtiity;

public class AdminpanelPage {
	@FindBy (xpath = "//span[.='Users']")
	private WebElement user;
	
	@FindBy (xpath = "//span[text()='Restaurant']")
	private WebElement restaurant;
	
	@FindBy (linkText = "Add Restaurant")
	private WebElement addrestaurantbtn;
	
	@FindBy (xpath = "//a[.='Add Category']")
	private WebElement addcategory;
	
	@FindBy (linkText = "All Restaurant")
	private WebElement allrestaurantbtn;
	
	@FindBy(xpath = "//span[text()='Menu']")
	private WebElement menu;
	
	@FindBy(xpath = "//a[text()='Add Menu']")
	private WebElement addmenu;
	
	@FindBy(xpath = "//a[text()='All Menues']")
	private WebElement allmenu;
	
	@FindBy(xpath = "//span[.='Orders']")
	private WebElement orders;
	
	@FindBy(xpath = "//img[@src='images/bookingSystem/user-icn.png']")
	private WebElement logoutimg;
	
	@FindBy(xpath = "//a[@href='logout.php']")
	private WebElement logout;
	
	public AdminpanelPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getUser() {
		return user;
	}

	public WebElement getRestaurant() {
		return restaurant;
	}

	public WebElement getAddrestaurantbtn() {
		return addrestaurantbtn;
	}

	public WebElement getAddcategory() {
		return addcategory;
	}

	public WebElement getAllrestaurantbtn() {
		return allrestaurantbtn;
	}

	public WebElement getMenu() {
		return menu;
	}

	public WebElement getAddmenu() {
		return addmenu;
	}

	public WebElement getOrders() {
		return orders;
	}
	
	public void clickusermodule() 
	{
		user.click();
	}
	public void clickRestaurantmodule() {
		restaurant.click();
	}
	public void clickAllRestaurantmodule() 
	{
		restaurant.click();
		allrestaurantbtn.click();
	}
	public void clickAddCategorymodule() 
	{
		restaurant.click();
		addcategory.click();
	}
	public void clickAddRestaurantmodule() 
	{
		restaurant.click();
		addrestaurantbtn.click();
	}
	public void clickMenumodule() 
	{
		menu.click();
	}
	public void clickAllMenuesmodule() 
	{
		menu.click();
		allmenu.click();
	}
	public void clickAddMenumodule() 
	{
		menu.click();
		addmenu.click();
	}
	public void clickOrders()
	{
		orders.click();
	}
	public void logout()
	{
		logoutimg.click();
		logout.click();
	}


}
