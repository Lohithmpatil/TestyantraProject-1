package com.crm.comcast.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createNewConatactPage {
	public createNewConatactPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}
	
	public WebElement getLastname() {
		return lastname;
	}

	@FindBy(name="lastname")
	private WebElement lastname;
	
	@FindBy(xpath="//input[@title=\"Save [Alt+S]\"]")
   private WebElement savebtn;
	
	@FindBy(xpath="//input[@title=\"Delete [Alt+D]\"]")
	private WebElement deleteBtn;
	
	@FindBy(name="search_text")
    private WebElement serch;
	
	@FindBy(xpath="//input[@value=\" Search Now \"]")
	private WebElement scearcgBtn;
	
	@FindBy(xpath="//span[@class=\"genHeaderSmall\"]")
	private String getText;
	
	

	public String getGetText() {
		return getText;
	}

	public WebElement getDeleteBtn() {
		return deleteBtn;
	}

	public WebElement getSerch() {
		return serch;
	}

	public WebElement getScearcgBtn() {
		return scearcgBtn;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	public void creatcontact(String lastName)
    {
    	lastname.sendKeys(lastName);
    	savebtn.click();
    }
}
