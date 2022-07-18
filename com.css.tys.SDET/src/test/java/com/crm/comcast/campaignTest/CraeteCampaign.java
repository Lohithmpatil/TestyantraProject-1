package com.crm.comcast.campaignTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.genericutitlity.BaseClass;
import com.crm.comcast.pomRepository.CampaignsInfo;
import com.crm.comcast.pomRepository.CampaignsPage;
import com.crm.comcast.pomRepository.HomePage;
import com.crm.comcast.pomRepository.LoginPage;
import com.crm.comcast.pomRepository.Productpage;
import com.crm.comcast.pomRepository.createCampaignsPage;
import com.crm.comcast.pomRepository.createProductPage;


@Listeners(com.crm.comcast.genericutitlity.Listnear.class)
public class CraeteCampaign extends BaseClass {
	
	
	@Test(groups= {"regressionTest"})
	public void CreateCampaigns() throws Throwable {
		
  //create a object in pom repository
          LoginPage lp=new LoginPage(driver);
          HomePage hm=new HomePage(driver);
         
		  CampaignsPage cp1=new CampaignsPage(driver);
          createCampaignsPage ccp=new createCampaignsPage(driver);
		  CampaignsInfo cpi=new CampaignsInfo(driver);
         
   //Get Random number
		   int intRanNum = jLib.getRandomNumber();
		       
   //Read the test data from exceL
		   String campaignname=eLib.getDataFromExcel("Sheet1", 0, 4)+intRanNum;
		
	//goto more
		   hm.getMorelink().click();
	       //wLib.mouseOverOnElement1(driver, hm.getMorelink());
	      
  //navigate campaign page
	      hm.getCampaignslink().click();
	      
	      
	//Fail testscript      
	     
	      
	      cp1.getContactImg().click();
	      
   //create a campaign
	      
	      ccp.getCampaignName().sendKeys(campaignname);
	      ccp.getSaveBtn().click();
	     
	//verify
	    
	      
	  String s=  cpi.getCampaignsucess().getText();
	  
	  
	  Assert.assertTrue(s.contains(campaignname));
	  
	  /* if(s.contains(campaignname))
		   
	   {
	    	 System.out.println("campaign created");
	     }
	     else
	     {
	    	 System.out.println("campaign not created");
	     }  */

	}

}
