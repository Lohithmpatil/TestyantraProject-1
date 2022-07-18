package com.crm.comcast.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class contactInfoPage {
	public contactInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[@class=\"dvHeaderText\"]")
	private WebElement createContactSucess;
	
	
	@FindBy(xpath="//span[@class=\"genHeaderSmall\"]")
	private WebElement DeleteContactMsg;

	public WebElement getCreateContactSucess() {
		return createContactSucess;
	}

	public WebElement getDeleteContactMsg() {
		return DeleteContactMsg;
	}
	
}
