package com.crm.comcast.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfo {
	public void ProductInfo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//span[@class=\"small\"]")
	private WebElement ceratePdtSucess;

	public WebElement getCeratePdtSucess() {
		return ceratePdtSucess;
	}
	
	
}
