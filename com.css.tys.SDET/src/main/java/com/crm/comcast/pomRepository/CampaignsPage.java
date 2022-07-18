package com.crm.comcast.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsPage 
{
	WebDriver driver;
	public CampaignsPage(WebDriver driver)
	{
		this. driver = driver;
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(xpath= "//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
	private WebElement campaignsImg;

	public WebElement getContactImg() {
		return campaignsImg;
	}
}
