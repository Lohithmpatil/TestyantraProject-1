package com.crm.comcast.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsInfo
{
	WebDriver driver;
  public CampaignsInfo(WebDriver driver) {

	  this. driver = driver;
	  PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//span[@class=\"dvHeaderText\"]")
private WebElement campaignsucess;
	
	
	public WebElement getCampaignsucess() {
		return campaignsucess;
	}
	
	
}
