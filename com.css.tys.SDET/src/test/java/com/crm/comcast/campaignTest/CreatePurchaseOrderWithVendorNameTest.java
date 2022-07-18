package com.crm.comcast.campaignTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.comcast.genericutitlity.ExcelUtility;
import com.crm.comcast.genericutitlity.FileUtility;
import com.crm.comcast.genericutitlity.JavaUtility;
import com.crm.comcast.genericutitlity.WebDriverUtility;

public class CreatePurchaseOrderWithVendorNameTest {

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
	       
	       //Read the test data from exceL
	        String campaignname=eLib.getDataFromExcel("Sheet1", 0, 4)+intRanNum;
         String productname=eLib.getDataFromExcel("Sheet1", 0, 5)+intRanNum;
         String  prod=eLib.getDataFromExcel("Sheet1", 1, 7)+intRanNum;
     	String  purchaseid=eLib.getDataFromExcel("Sheet1", 2, 7)+intRanNum;
     	String city=eLib.getDataFromExcel("Sheet1", 3, 7)+intRanNum;
     	String state=eLib.getDataFromExcel("Sheet1", 4, 7)+intRanNum;
     	String code=eLib.getDataFromExcel("Sheet1", 5, 7)+intRanNum;
     	String subject=eLib.getDataFromExcel("Sheet1", 6, 7)+intRanNum;
     	String code1=eLib.getDataFromExcel("Sheet1", 7, 7)+intRanNum;
     	
     	
      	//System.setProperty("webdriver.chrome.driver", "D:\\\\Selenium\\\\chromedriver_win32\\\\chromedriver.exe");
       	WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        wLib.waitForElementInDOM(driver);
        driver.get(url);
        driver.findElement(By.name("user_name")).sendKeys(username);
        driver.findElement(By.name("user_password")).sendKeys(password);
        driver.findElement(By.id("submitButton")).click();
        
        
        WebElement web=driver.findElement(By.xpath("//img[@src=\"themes/softed/images/menuDnArrow.gif\"]"));
        wLib.mouseOverOnElement(driver, web);
		
        driver.findElement(By.name("Purchase Order")).click();
        driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
        driver.findElement(By.id("tracking_no")).sendKeys(purchaseid);
        driver.findElement(By.id("ship_city")).sendKeys(city);
       driver.findElement(By.id("ship_state")).sendKeys(state);
        driver.findElement(By.id("ship_code")).sendKeys(code);
	 //driver.findElement(By.id("ship_country")).sendKeys(country);
       driver.findElement(By.name("subject")).sendKeys(subject);
       driver.findElement(By.id("ship_code")).sendKeys(code1);
       driver.findElement(By.cssSelector("[src=\"themes/softed/images/select.gif\"]")).click();
       
       wLib.swithToWindow(driver, "Vendors");
       
       
      	driver.findElement(By.id("search_txt")).sendKeys("madhu");
      	driver.findElement(By.id("11")).click();
      	driver.findElement(By.xpath("//a[@href=\"javascript:window.close();\"]")).click();
      	driver.findElement(By.cssSelector("[accesskey=\"S\"]")).click();
      
      	wLib.swithToWindow(driver, "Purchase Order");
        	
        
       	 WebElement wb=driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
       	  wLib.mouseOverOnElement(driver, wb);
       	 driver.findElement(By.xpath("//a[text()=\"Sign Out\"]")).click();
       	 driver.close();
         }
	}
