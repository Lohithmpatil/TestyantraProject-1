package com.crm.comcast.genericutitlity;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listnear implements ITestListener{
	
	
public void OnTestFailure(ITestResult result) throws IOException {
//String testname=	result.getMethod().getMethodName();
	//System.out.println("====Execute===");
	//EventFiringWebDriver eDriver=new 	EventFiringWebDriver(BaseClass.sdriver);
    
    TakesScreenshot ts=(TakesScreenshot)BaseClass.sdriver;
    File src=ts.getScreenshotAs(OutputType.FILE);
    File trg= new File("./screenshot.png");
    FileUtils.copyFile(src, trg);
   /*  try 
     {
    	 FileUtils.copyFile(src, trg);
     }
     catch(IOException e)
     {
    	 e.printStackTrace();
     }*/
  
}
}