package com.crm.comcast.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createProductPage {
	WebDriver driver;
	public createProductPage(WebDriver driver) 
	{
		this. driver = driver;
	PageFactory.initElements(driver, this);
	}
	public WebDriver getDriver() {
		return driver;
	}
	@FindBy(name="productname")
	private WebElement prodcutName;
	
	@FindBy(xpath="//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveBtn;

	public WebElement getProdcutName() {
		return prodcutName;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	
}
