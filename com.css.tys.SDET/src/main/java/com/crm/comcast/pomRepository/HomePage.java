package com.crm.comcast.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
	
		this. driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath= "//a[@href=\"index.php?module=Accounts&action=index\"]")     //Rule 2 Identify all the elements using @find and @findBYs and @findAll
	private WebElement organizationlink;
	
	@FindBy(xpath = "//a[text()=\"Products\"]")   
	private WebElement productlink;
	

	@FindBy(linkText= "Leads")   
	private WebElement leadlink;
	
	@FindBy(xpath= "//a[text()=\"Contacts\"]")   
	private WebElement contactlink;
	
	@FindBy(xpath= "//img[@src=\"themes/softed/images/menuDnArrow.gif\"]")   
	private WebElement morelink;
	
	@FindBy(name="Campaigns")
	private WebElement campaignslink;
	
	@FindBy(name="Vendors")
  private WebElement vendorslink;
	
	

	public WebElement getCampaignslink() {
		return campaignslink;
	}
	public WebElement getVendorslink() {
		return vendorslink;
	}
	public WebElement getProductlink() {
		return productlink;
	}
	public WebElement getMorelink() {
		return morelink;
	}
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getLeadlink() {
		return leadlink;
	}
	@FindBy(xpath= "//a[text()=\"Sign Out\"]")     
	private WebElement signOutlink;
	


	
	@FindBy(xpath= "//img[@src=\"themes/softed/images/user.PNG\"]")     
	private WebElement administratorimg;


	public WebElement getOrganizationlink() {
		return organizationlink;
	}
	public WebElement getContactlink() {
		return contactlink;
	}
	public WebElement getSignOutlink() {
		return signOutlink;
	}
	public WebElement getAdministratorimg() {
		return administratorimg;
	}
	
	public void logout() {
		Actions act=new Actions(driver);
		act.moveToElement(administratorimg).perform();
		signOutlink.click();
		
	}
	public void clickOnOrgination()
	{
		organizationlink.click();
	}
	public void clickOnContactLink()
	{
		contactlink.click();
	}
	
	public void clickonproductLink()
	{
		productlink.click();
	}
    public void more() {
    	Actions act = new Actions(driver);
    act.moveToElement(morelink).perform();
    campaignslink.click();
    Actions act1 = new Actions(driver);
    act1.moveToElement(vendorslink).perform();
    vendorslink.click();
    }



}



