package com.crm.comcast.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Productpage {
	public Productpage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	
		
	@FindBy(xpath="//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
	private WebElement producImg;
	
	
	public WebElement getProducImg() {
		return producImg;
	}
   public void createProductclick()
   {
	   producImg.click(); 
   }
}
