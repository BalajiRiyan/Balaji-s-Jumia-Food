package com.jumia.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericutilities.WebDriverUtiity;

public class RestaurantPage {
	@FindBy (xpath = "//a[.='Eataly']")
	private WebElement viewmenu;
	
	@FindBy (xpath = "//input[@value = 'Add To Cart']")
	private WebElement addtocart;
	
	@FindBy (xpath = "//a[.='Checkout']")
	private WebElement checkout;
	
	@FindBy (name = "submit")
	private WebElement ordernow;
	
	@FindBy (xpath = "//tbody/tr[last()]")
	private WebElement placedorder;
	
	@FindBy (xpath = "//a[.='Pink Spaghetti Gamberoni']")
	private WebElement yourorder;
	
	public RestaurantPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getViewmenu() {
		return viewmenu;
	}

	public WebElement getAddtocart() {
		return addtocart;
	}

	public WebElement getCheckout() {
		return checkout;
	}

	public WebElement getOrdernow() {
		return ordernow;
	}
	
	public WebElement getPlacedorder() {
		return placedorder;
	}
	
	
	public WebElement getYourorder() {
		return yourorder;
	}

	public void placeOrder(WebDriverUtiity wdu, WebDriver driver) {
		viewmenu.click();
		String expectedorder = yourorder.getText();
		addtocart.click();
		checkout.click();
		ordernow.click();
		wdu.acceptAlert(driver);
		wdu.implicitwait(driver);
		wdu.acceptAlert(driver);
		String actualorder = placedorder.getText();
	    System.out.println(actualorder);
		if(actualorder.contains(expectedorder))
		{
			System.out.println("Order is placed");
		}
		else
		{
			System.out.println("Order is not placed");
		}
        driver.close();
	}

}
