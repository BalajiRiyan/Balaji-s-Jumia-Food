package com.jumia.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomepageBeforeLogin {
	@FindBy(xpath = "//a[.='Login']")
	private WebElement login;

	public HomepageBeforeLogin(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLogin() {
		return login;
	}
	public void clickLogin() {
		login.click();
	}
	

}
