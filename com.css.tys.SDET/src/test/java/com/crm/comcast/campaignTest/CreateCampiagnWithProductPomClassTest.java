package com.crm.comcast.campaignTest;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.comcast.genericutitlity.BaseClass;
import com.crm.comcast.genericutitlity.ExcelUtility;
import com.crm.comcast.genericutitlity.FileUtility;
import com.crm.comcast.genericutitlity.JavaUtility;
import com.crm.comcast.genericutitlity.WebDriverUtility;
import com.crm.comcast.pomRepository.CampaignsInfo;
import com.crm.comcast.pomRepository.CampaignsPage;
import com.crm.comcast.pomRepository.HomePage;
import com.crm.comcast.pomRepository.LoginPage;
import com.crm.comcast.pomRepository.Productpage;
import com.crm.comcast.pomRepository.createCampaignsPage;
import com.crm.comcast.pomRepository.createProductPage;

public class CreateCampiagnWithProductPomClassTest extends  BaseClass{
@Test(groups= {"smokeTest"})
	public void CreateCampaign() throws Throwable {
		
	
	//create a object in utility
			/*	WebDriverUtility wLib= new WebDriverUtility();
				FileUtility fLib= new FileUtility();
				ExcelUtility eLib= new ExcelUtility();
				JavaUtility jLib= new JavaUtility();
				
				//Read the common data from the property file
				
			       String url=fLib.getPropertyKeyValue("url");
			       String browser=fLib.getPropertyKeyValue("browser");
			       String username= fLib.getPropertyKeyValue("username");
			       String password= fLib.getPropertyKeyValue("password");  */
		
			 //Get Random number
				   int intRanNum = jLib.getRandomNumber();
				       
		     //Read the test data from exceL
				    String campaignname=eLib.getDataFromExcel("Sheet1", 0, 4)+intRanNum;
			        String productname=eLib.getDataFromExcel("Sheet1", 0, 5)+intRanNum;
					
			  //lunch browser
			      //   WebDriver driver=new ChromeDriver();
			     //    wLib.waitForElementInDOM(driver);
			      //   driver.get(url); 
			         
			 		
	            //create a object in pom repository
			         LoginPage lp=new LoginPage(driver);
			         HomePage hm=new HomePage(driver);
			 		 CampaignsPage cp1=new CampaignsPage(driver);
			          createCampaignsPage ccp=new createCampaignsPage(driver);
			 		  CampaignsInfo cpi=new CampaignsInfo(driver);
			          createProductPage cp=new createProductPage(driver);
			          Productpage pp=new Productpage(driver);
	 //login to app 	 					
	 // lp.logintoApp(username, password);
     // lp.getLogInBtn().click();
		
		
		//Navigate prodcut page
      hm.getProductlink().click();
      
      
      
      //create product
      pp.getProducImg().click();
      cp.getProdcutName().sendKeys(productname);
      cp.getSaveBtn().click();
      
      
      //goto more
    // hm.getMorelink().click();
      wLib.mouseOverOnElement1(driver, hm.getMorelink());
      
      //navigate campaign page
      hm.getCampaignslink().click();
      
      
      cp1.getContactImg().click();
      
      //create a campaign
      
      ccp.getCampaignName().sendKeys(campaignname);
      
}
      @Test(groups= {"regressionTest"})
      public void CreateCampaignwithProduct() throws Throwable
      {
    	  //Get Random number
		   int intRanNum = jLib.getRandomNumber();
		       
    //Read the test data from exceL
		    String campaignname=eLib.getDataFromExcel("Sheet1", 0, 4)+intRanNum;
	        String productname=eLib.getDataFromExcel("Sheet1", 0, 5)+intRanNum;  
    	  
    	  
	        //create a object in pom repository
	         LoginPage lp=new LoginPage(driver);
	         HomePage hm=new HomePage(driver);
	 		 CampaignsPage cp1=new CampaignsPage(driver);
	          createCampaignsPage ccp=new createCampaignsPage(driver);
	 		  CampaignsInfo cpi=new CampaignsInfo(driver);
	          createProductPage cp=new createProductPage(driver);
	          Productpage pp=new Productpage(driver);	  
    	  
   //navigate to product img
	          
    ccp.getCeratepdtimg().click();
     ccp.clickproductimg();
      
      
      //switch to child window
     wLib.swithToWindow(driver, "products&action");
      
     // search product
      ccp.getSearchName().sendKeys(campaignname);
      ccp.getSearcBtn();
      
      ccp.getPdtName().click();
      
      
      // switch to parent window
       wLib.swithToWindow(driver, campaignname);
      
     ccp.getSaveBtn().click();
     
     //campaign created are not 
     
   String s=  cpi.getCampaignsucess().getText();
   wLib.waitForElement(driver, cpi.getCampaignsucess());
   if(s.contains(campaignname))
   {
    	 System.out.println("campaign information created");
     }
     else
     {
    	 System.out.println("campaign information not created");
     }  
	   
	  //logout the window
   hm.logout();
   
   //close the driver
   
   driver.close();  
	}
}
