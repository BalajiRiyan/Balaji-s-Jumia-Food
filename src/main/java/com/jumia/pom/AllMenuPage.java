package com.jumia.pom;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllMenuPage {
	@FindBy(xpath = "//tbody/tr[last()]/td[6]/a[2]")
	private WebElement editbtn;
	@FindBy(xpath = "//tbody/tr[last()]/td[6]/a[1]")
	private WebElement deletebtn;
	
	public AllMenuPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getEditbtn() {
		return editbtn;
	}

	public WebElement getDeletebtn() {
		return deletebtn;
	}
	
	public void deletemenu() throws EncryptedDocumentException, IOException
	{
		deletebtn.click();
	}
	public void editmenu()
	{
		editbtn.click();
	}

}
