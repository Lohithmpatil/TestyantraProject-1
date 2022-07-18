package com.crm.comcast.contactTest;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.comcast.genericutitlity.BaseClass;
import com.crm.comcast.genericutitlity.DataBaseUtility;
import com.crm.comcast.genericutitlity.ExcelUtility;
import com.crm.comcast.genericutitlity.FileUtility;
import com.crm.comcast.genericutitlity.WebDriverUtility;
import com.crm.comcast.pomRepository.HomePage;
import com.crm.comcast.pomRepository.LoginPage;
import com.crm.comcast.pomRepository.contactInfoPage;
import com.crm.comcast.pomRepository.craeteContactPage;
import com.crm.comcast.pomRepository.createNewConatactPage;
@Listeners(com.crm.comcast.genericutitlity.Listnear.class)
public class createContact  extends BaseClass{
	@Test
	public void craetecontact() throws Throwable
	{
	
  ExcelUtility eu;
		/* create object for object   generic utility
	
	FileUtility fu=new FileUtility();
	WebDriverUtility wu=new WebDriverUtility();
	ExcelUtility eu=new ExcelUtility();
	DataBaseUtility du=new DataBaseUtility();
	

	//Read the common data from the property file
	
       String url=fu.getPropertyKeyValue("url");
       String browser=fu.getPropertyKeyValue("browser");
       String username= fu.getPropertyKeyValue("username");
       String password= fu.getPropertyKeyValue("password");

 
	
	   
	//lunch browser
       WebDriver driver=new ChromeDriver();
       wu.waitForElementInDOM(driver);
       driver.get(url);   
	   
	//Login to page
       LoginPage lp=new LoginPage(driver);
       lp.logintoApp(username, password);
       lp.getLogInBtn().click(); */
  
        //Get Random number
        int intRanNum = fLib.getRandomNumber();
  
		//Read data From Excel
		  String lastname=eLib.getDataFromExcel("Sheet1", 1, 0)+intRanNum;
		   
       
         // navigate to contact page
         HomePage hm=new HomePage(driver);
         hm.getContactlink().click();
       
        //create contact img
       
       craeteContactPage crt=new craeteContactPage(driver);
       crt.getCreateContactImg().click();
       
       //create contact last name
       createNewConatactPage cnew= new createNewConatactPage(driver);
       cnew.getLastname().sendKeys(lastname);
       cnew.getLastname();
       cnew.getSavebtn().click();
      
  
	  //verify
      contactInfoPage cifo=new contactInfoPage(driver);
     //wLib.waitForElement(driver, cifo.getCreateContactSucess());
      String  s =  cifo.getCreateContactSucess().getText();
    
      SoftAssert t = new SoftAssert();
      t.assertEquals(lastname, s);
  /*  if(s.contains(lastname))
{
System.out.println(" create contact");	

}
else
{
	System.out.println(" not create contact");		
}*/
	}
}
