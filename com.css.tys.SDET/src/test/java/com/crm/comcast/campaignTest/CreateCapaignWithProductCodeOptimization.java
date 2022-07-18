package com.crm.comcast.campaignTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.comcast.genericutitlity.ExcelUtility;
import com.crm.comcast.genericutitlity.FileUtility;
import com.crm.comcast.genericutitlity.JavaUtility;
import com.crm.comcast.genericutitlity.WebDriverUtility;

public class CreateCapaignWithProductCodeOptimization {


	public static void main(String[] args) throws Throwable {             
		
		
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
    		   
    	//Launch the browser
      //System.setProperty("webdriver.chrome.driver", "D:\\\\Selenium\\\\chromedriver_win32\\\\chromedriver.exe");
       WebDriver driver=new ChromeDriver();
       //wLib.waitForElementInDOM(driver);
       
      /* WebDriver driver=null;
       if(browser.equals("chrome"))
       {
    	   driver=new ChromeDriver();
       }
       else if(browser.equals("firefox"))
       {
    	   driver=new FirefoxDriver();
       }
       else {
    	   driver=new ChromeDriver();
       }
      
       //Login to App*/
       
        wLib.waitForElementInDOM(driver);
       driver.get(url);
       driver.findElement(By.name("user_name")).sendKeys(username);
       driver.findElement(By.name("user_password")).sendKeys(password);
       driver.findElement(By.id("submitButton")).click();
       
     //Navigate the product page
        driver.findElement(By.xpath("//a[text()='Products']")).click();
       
       //navigate to create product page
       driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
       
       //navigate to create a product page
       driver.findElement(By.cssSelector("[alt=\"Create Product...\"]")).click();
       driver.findElement(By.name("productname")).sendKeys(productname);
       driver.findElement(By.cssSelector("[accesskey=\"S\"]")).click();
    		   
      
		//navigate to campaign page
	   driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']")).click();	
		//wLib.mouseOverOnElement(driver, more);
		
		 driver.findElement(By.xpath("//a[text()='Campaigns']")).click();
		 
		 //navigate to create campaign page
		 driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
		    
		//create a anew campaign with product
		 driver.findElement(By.name("campaignname")).sendKeys(campaignname);
		 driver.findElement(By.xpath("//img[@src=\"themes/softed/images/select.gif\"]")).click();
		 
		 wLib.swithToWindow(driver, "products&action");
		
		 
	   driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys(productname);
       driver.findElement(By.cssSelector("[type=\"button\"]")).click();
       driver.findElement(By.xpath("//a[text()='Vtiger Single User Pack']")).click();
       
       wLib.swithToWindow(driver, "campaign&action");
       
       driver.findElement(By.cssSelector("[accesskey=\"S\"]")).click();
       
       String s=driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
       System.out.println(s);
       if(s.contains(campaignname))
       {
      	 System.out.println("campaign information created");
       }
       else
       {
      	 System.out.println("campaign information not created");
       }

   	 WebElement wb=driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
   	 wLib.mouseOverOnElement(driver, wb);
   	 driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
   	 driver.close();
   		}
	}



