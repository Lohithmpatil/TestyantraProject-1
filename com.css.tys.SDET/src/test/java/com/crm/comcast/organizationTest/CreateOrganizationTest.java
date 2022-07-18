package com.crm.comcast.organizationTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.crm.comcast.genericutitlity.ExcelUtility;
import com.crm.comcast.genericutitlity.FileUtility;
import com.crm.comcast.genericutitlity.JavaUtility;
import com.crm.comcast.genericutitlity.WebDriverUtility;
import com.crm.comcast.pomRepository.CreateNewOrganizationPage;
import com.crm.comcast.pomRepository.HomePage;
import com.crm.comcast.pomRepository.LoginPage;
import com.crm.comcast.pomRepository.organizationInfo;
import com.crm.comcast.pomRepository.organizationPage;

public class CreateOrganizationTest {
	public static void main(String [] args) throws Throwable
	{
	//create a object in utility
		
		WebDriverUtility wLib= new WebDriverUtility();
		FileUtility fLib= new FileUtility();
		ExcelUtility eLib= new ExcelUtility();
		JavaUtility jLib= new JavaUtility();
		
		
		//Read the common data from the property file
		
       String url=fLib.getPropertyKeyValue("url");
       String browser=fLib.getPropertyKeyValue("browser");
       String username= fLib.getPropertyKeyValue("username");
       String password= fLib.getPropertyKeyValue("password");
       
     //Get Random number
       int intRanNum = jLib.getRandomNumber();
       
    //Read the test data from excel
       
       String campaignname=eLib.getDataFromExcel("Sheet1", 0, 4)+intRanNum;
       String productname=eLib.getDataFromExcel("Sheet1", 0, 5)+intRanNum;
       
	   
	// step- 1 Launch the browser
  //System.setProperty("webdriver.chrome.driver", "D:\\\\Selenium\\\\chromedriver_win32\\\\chromedriver.exe");
   WebDriver driver=new ChromeDriver();
   wLib.waitForElementInDOM(driver);
   driver.get(url);
   
   //step-2  login to app
   LoginPage lp=new LoginPage(driver);
   lp.logintoApp(username, password);
   lp.getLogInBtn().click();
   
   
  //step-3 navigate to organization link
   HomePage hm=new HomePage(driver);
     hm.clickOnOrgination();
   
 //step-4 navigate to organization page
   organizationPage op=new organizationPage(driver);
   op.getCreateOrganizationImg().click();
   
   //step-5 create organization
   CreateNewOrganizationPage onp=new CreateNewOrganizationPage(driver);
   onp.createOrg(productname);
   
   //step-6 verify
   
   organizationInfo opi=new organizationInfo(driver);
   wLib.waitForElement(driver, opi.getOrgInfo());
   String actususmsg=opi.getOrgInfo().getText();
   
   
   Assert.assertTrue(actususmsg.contains(productname));
   
   
   
   
 /*  if(actususmsg.contains(productname)) {
	   System.out.println("organization is cerated =yes");
   }
	   else
	   {
		   
		   System.out.println("organization is cerated =no"); 
	   }
	   */
   //step- 7 logout

	hm.logout();
	
	
	//step=8 close the browser
	driver.close();
	   }
   
	}

