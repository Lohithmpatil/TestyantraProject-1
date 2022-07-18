package com.crm.comcast.organizationTest;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.genericutitlity.BaseClass;
import com.crm.comcast.pomRepository.CreateNewOrganizationPage;
import com.crm.comcast.pomRepository.HomePage;
import com.crm.comcast.pomRepository.organizationInfo;
import com.crm.comcast.pomRepository.organizationPage;

public class CreateOrganizationWith_Baseclass extends BaseClass {
	
@Test
	public void createOrgTest() throws Throwable {
		
		int intRanNum=jLib.getRandomNumber();
		  
		
		//test script data
		String campaignname=eLib.getDataFromExcel("Sheet1", 0, 4)+intRanNum;
	
	 //navigate the organization page
		HomePage hm=new HomePage(driver);
		hm.clickOnOrgination();
		
	//navigate to create organization page img
		organizationPage op=new organizationPage(driver);
		op.getCreateOrganizationImg().click();
		
		 //create organization
		   CreateNewOrganizationPage onp=new CreateNewOrganizationPage(driver);
		   onp.createOrg(campaignname);
		   
		  //step-6 verify
		   
		   organizationInfo opi=new organizationInfo(driver);
		  wLib.waitForElement(driver, opi.getOrgInfo());
		   String actususmsg=opi.getOrgInfo().getText();
		   
		 Assert.assertTrue(actususmsg.contains(campaignname));
		   
		/*  if(actususmsg.contains(campaignname)) {
			   System.out.println("organization is cerated =yes");
		  }
		   else
			  {
				   
				   System.out.println("organization is cerated =no"); 
			   }*/
			   
		
				
	}	

}
