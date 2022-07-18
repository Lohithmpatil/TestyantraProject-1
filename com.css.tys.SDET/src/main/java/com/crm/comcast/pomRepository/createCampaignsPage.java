package com.crm.comcast.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createCampaignsPage {
	public createCampaignsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="campaignname")
	private WebElement campaignName;
	
	
	@FindBy(xpath="//img[@src=\"themes/softed/images/select.gif\"]")
	private WebElement ceratepdtimg; 
	
	
	public WebElement getCeratepdtimg() {
		return ceratepdtimg;
	}

	@FindBy(xpath="//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveBtn;
	
	@FindBy(name="search_text")
	private WebElement searchName;
	
	@FindBy(xpath="//input[@type=\"button\"]")
	private WebElement searcBtn;
	
	
	@FindBy(xpath="//a[@href=\"javascript:window.close();\"]")
	private WebElement pdtName;
	
	
	@FindBy(xpath="//span[@class=\"dvHeaderText\"]")
	private WebElement campaignCreateSucess;


	public WebElement getCampaignCreateSucess() {
		return campaignCreateSucess;
	}


	public WebElement getPdtName() {
		return pdtName;
	}


	public WebElement getSearchName() {
		return searchName;
	}


	public WebElement getSearcBtn() {
		return searcBtn;
	}


	public WebElement getCampaignName() {
		return campaignName;
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void clickproductimg() {
		 ceratepdtimg.click();
	}
}
