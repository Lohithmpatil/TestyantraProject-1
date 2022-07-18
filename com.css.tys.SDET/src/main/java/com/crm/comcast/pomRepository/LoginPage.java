package com.crm.comcast.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mysql.cj.jdbc.Driver;

public class LoginPage { //Rule 1 Create a separate java class for every in a application
	
//Rule 3 Execute all the Elements and Initialize page Factory.initElements 
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this. driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name= "user_name")     //Rule 2 Identify all the elements using @find and @findBYs and @findAll
	private WebElement userNameEdt;
	
	@FindBy(name= "user_password")
	private WebElement passWordEdt;
	

	@FindBy(id= "submitButton")
	private WebElement logInBtn;

//Right click > source > Generate getters and Setters method > click > select getters > ok
	
	//Rule 4 Declare all the elements as private and provide the method .business method for(utilization)
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}


	public WebElement getPassWordEdt() {
		return passWordEdt;
	}


	public WebElement getLogInBtn() {
		return logInBtn;
	}
	
	public void logintoApp( String username , String password) {
    userNameEdt.sendKeys(username);
	passWordEdt.sendKeys(password);
    logInBtn.click();
	}


}

