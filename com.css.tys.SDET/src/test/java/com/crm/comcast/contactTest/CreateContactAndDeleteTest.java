package com.crm.comcast.contactTest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.genericutitlity.BaseClass;
import com.crm.comcast.genericutitlity.ExcelUtility;
import com.crm.comcast.genericutitlity.FileUtility;
import com.crm.comcast.genericutitlity.JavaUtility;
import com.crm.comcast.genericutitlity.WebDriverUtility;
import com.crm.comcast.pomRepository.HomePage;
import com.crm.comcast.pomRepository.contactInfoPage;
import com.crm.comcast.pomRepository.craeteContactPage;
import com.crm.comcast.pomRepository.createNewConatactPage;

public class CreateContactAndDeleteTest extends BaseClass
{
	@Test(groups= {"smokeTest"})
public void CreateContact() throws Throwable 
{
		
	/*	//Create a object
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		WebDriverUtility wLib= new WebDriverUtility();
		JavaUtility jLib= new JavaUtility();
		
		//Read the data from the property file
		

	       String url=fLib.getPropertyKeyValue("url");
	       String browser=fLib.getPropertyKeyValue("browser");
	       String username= fLib.getPropertyKeyValue("username");
	       String password= fLib.getPropertyKeyValue("password");
	       
	       //Get Random number
	        int intRanNum = jLib.getRandomNumber();
	       
	       //Read the test data from excel
	       
	       String customername=eLib.getDataFromExcel("Sheet1", 0, 4)+intRanNum;
	      // String productname=eLib.getDataFromExcel("Sheet1", 0, 5)+intRanNum;
		
	
       //System.setProperty("webdriver.chrome.driver", "D:\\\\Selenium\\\\chromedriver_win32\\\\chromedriver.exe");
       WebDriver driver=new ChromeDriver();
       driver.manage().window().maximize();
       wLib.waitForElementInDOM(driver);
       driver.get(url);
       
       driver.findElement(By.name("user_name")).sendKeys(username);
       driver.findElement(By.name("user_password")).sendKeys(password);
       driver.findElement(By.id("submitButton")).click();
       
   driver.findElement(By.xpath("//a[text()='Contacts']")).click();
   driver.findElement(By.cssSelector("[title=\"Create Contact...\"]")).click();
  
   driver.findElement(By.name("lastname")).sendKeys(customername);
   driver.findElement(By.cssSelector("[accesskey=\"S\"]")).click();
  driver.findElement(By.xpath("//input[@class=\"crmbutton small delete\"][1]")).click();
 
 Alert alt=driver.switchTo().alert();
 alt.accept();
 
 //wLib=swithToAlertWindowAndAccpect(driver ,act);
 
 driver.findElement(By.xpath("//input[@name=\"search_text\"]")).sendKeys("patil");
 WebElement s=driver.findElement(By.xpath("//select[@id=\"bas_searchfield\"]"));
 Select s1=new Select(s);
 driver.findElement(By.xpath("//select[@id=\"bas_searchfield\"]"));
 s1.selectByIndex(2);
 driver.findElement(By.xpath("//input[@class=\"crmbutton small create\"]")).click();
 String t=driver.findElement(By.xpath("//span[@class='genHeaderSmall']")).getText();
 System.out.println(t);
		 */

	  //Get Random number
	  int intRanNum = fLib.getRandomNumber();

	//Read data From Excel
	   String lastname=eLib.getDataFromExcel("Sheet1", 1, 0)+intRanNum;
	   
   
 // navigate to contact page
   HomePage hm=new HomePage(driver);
   hm.clickOnContactLink();
   
 //craete contact img
   
   craeteContactPage crt=new craeteContactPage(driver);
   crt.getCreateContactImg().click();
   
   //create contact last name
   createNewConatactPage cnew= new createNewConatactPage(driver);
   cnew.getLastname().sendKeys(lastname);
   cnew.getLastname();
   cnew.getSavebtn().click();
}


  @Test(groups= {"regressionTest"})
  public void deleteContact() throws Throwable
  {
	//Get Random number
	  int intRanNum = fLib.getRandomNumber();

	//Read data From Excel
	   String lastname=eLib.getDataFromExcel("Sheet1", 1, 0)+intRanNum;
	   
   
 // navigate to contact page
   HomePage hm=new HomePage(driver);
   hm.clickOnContactLink();
   
 //craete contact img
   
   craeteContactPage crt=new craeteContactPage(driver);
   crt.getCreateContactImg().click();
   
   //create contact last name
   createNewConatactPage cnew= new createNewConatactPage(driver);
   cnew.getLastname().sendKeys(lastname);
   cnew.getLastname();
   cnew.getSavebtn().click();
   //delete contact
  cnew.getDeleteBtn().click();
  
  //handle popup
  wLib.swithToAlertWindowAndAccpect(driver, lastname);
   
  
  //srecg for conatact
  cnew.getSerch().sendKeys(lastname);
  cnew.getScearcgBtn().click();	
  
  //verify
  contactInfoPage cifo=new contactInfoPage(driver);
 //wLib.waitForElement(driver, cifo.getDeleteContactMsg());
  String con=cifo.getDeleteContactMsg().getText();
  
  Assert.assertTrue(con.contains(lastname));
  
  if(con.contains(lastname))
  {
	  System.out.println("contact  found");
  }
  else
  {
	  System.out.println("contact not found");
  }
   }
}
