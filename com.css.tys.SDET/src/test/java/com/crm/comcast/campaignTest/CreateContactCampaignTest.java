package com.crm.comcast.campaignTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateContactCampaignTest {


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("C:\\Users\\asus\\Desktop\\commondata.properties.txt");
        Properties pobj=new Properties();
        pobj.load(fis);
        String url=pobj.getProperty("url");
       String username=pobj.getProperty("username");
       String password=pobj.getProperty("password");
       System.out.println("url is "+url);
       System.out.println("username is"+username);
       System.out.println("password is "+password);
       System.setProperty("webdriver.chrome.driver", "D:\\\\Selenium\\\\chromedriver_win32\\\\chromedriver.exe");
       WebDriver driver=new ChromeDriver();
       driver.manage().window().maximize();
       //driver.manage().timeouts().implicitlyWait(Duration of seconds(10));
       driver.get(url);
       driver.findElement(By.name("user_name")).sendKeys(username);
       driver.findElement(By.name("user_password")).sendKeys(password);
       driver.findElement(By.id("submitButton")).click();
   driver.findElement(By.xpath("//a[text()='Products']")).click();
   driver.findElement(By.cssSelector("[alt=\"Create Product...\"]")).click();
   FileInputStream fis1= new FileInputStream("C:\\Users\\asus\\Desktop\\Exel.xlsx");
	Workbook book=WorkbookFactory.create(fis1);
	org.apache.poi.ss.usermodel.Sheet sh=book.getSheet("sheet1");
	String  data=sh.getRow(0).getCell(0).getStringCellValue();
   Random ru=new Random();
   int num=ru.nextInt(1000);
   String exputcustmername="patil";
   exputcustmername=exputcustmername+num;
   driver.findElement(By.name("productname")).sendKeys(exputcustmername);
  driver.findElement(By.cssSelector("[accesskey=\"S\"]")).click();
  Actions act=new Actions(driver);
  WebElement web=driver.findElement(By.xpath("//img[@src=\"themes/softed/images/menuDnArrow.gif\"]"));
  act.moveToElement(web).build().perform();
  driver.findElement(By.xpath("//a[text()='Campaigns']")).click();
  driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
 Random name=new Random();
 int num1=name.nextInt(1000);
 String exputcustmername1="bmw";
 exputcustmername1=exputcustmername1+num;
 driver.findElement(By.name("campaignname")).sendKeys(exputcustmername1);
 driver.findElement(By.xpath("//img[@src=\"themes/softed/images/select.gif\"]")).click();
 String parentTitle = driver.getTitle();
 java.util.Set<String> set=driver.getWindowHandles();
 Iterator<String> it =set.iterator();
 while(it.hasNext())
 {
	 String wId = it.next();
	 driver.switchTo().window(wId);
	 String currentWindowhTitle = driver.getTitle();
	 //if(currentWindowhTitle.contains(parentTitle))
		// break();
 }
	 
 }
 
 
/*String parentid=driver.getWindowHandle();
java.util.Set<String>allchildid=driver.getWindowHandles();
for(String childid:allchildid)
{
	if(!parentid.equals(childid));
	{
	driver.switchTo().window(childid);
	}
}
 
 driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("abcd1234");
 driver.findElement(By.cssSelector("[type=\"button\"]")).click();
 driver.findElement(By.xpath("//a[text()='abcd1234']")).click();
 driver.switchTo().window(parentid);
 driver.findElement(By.cssSelector("[accesskey=\"S\"]")).click();
 String s=driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
 System.out.println(s);
 if(exputcustmername1.contains(data))
 {
	 System.out.println("campaign information created");
 }
 else
 {
	 System.out.println("campaign information not created"); 
 }
 Actions act1=new Actions(driver);
 WebElement wb=driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
 act1.moveToElement(wb).perform();
 driver.findElement(By.xpath("//a[text()=\"Sign Out\"]")).click();
 //driver.close();*/
	}
//}
