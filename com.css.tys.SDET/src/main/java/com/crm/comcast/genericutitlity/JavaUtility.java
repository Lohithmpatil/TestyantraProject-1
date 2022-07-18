package com.crm.comcast.genericutitlity;

import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int getRandomNumber() {
	
	//it used to generate a random number
		
	Random random=new Random();
	int intrandom = random.nextInt(1000);
	return intrandom;
	}
	
	//used to get system date and time in IST form
	
	public String getSystemDateandTime() {
		Date date = new Date();
		return toString();
		
	}
	
	

}
