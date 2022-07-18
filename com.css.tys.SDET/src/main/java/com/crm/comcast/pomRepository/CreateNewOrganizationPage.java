package com.crm.comcast.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganizationPage {
	public CreateNewOrganizationPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="accountname")
	private WebElement CreateOrganizationName;
	
	@FindBy(xpath="//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveBtn;

	public WebElement getCreateOrganizationName() {
		return CreateOrganizationName;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createOrg(String orgName) {
	CreateOrganizationName.sendKeys(orgName);
	saveBtn.click();
	}
    
}
