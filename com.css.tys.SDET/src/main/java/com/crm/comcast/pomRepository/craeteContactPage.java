package com.crm.comcast.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class craeteContactPage {
	public craeteContactPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
	private WebElement createContactImg;

	public WebElement getCreateContactImg() {
		return createContactImg;
	}

	
	
}
