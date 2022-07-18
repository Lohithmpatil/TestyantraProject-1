package com.crm.comcast.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class organizationPage {
	public organizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
	private WebElement createOrganizationImg;


	public WebElement getCreateOrganizationImg() {
		return createOrganizationImg;
	}	
}
