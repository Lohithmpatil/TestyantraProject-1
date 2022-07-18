package com.crm.comcast.genericutitlity;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	
	//its used to read the data from commonData.properties File based on Key which you pass as an argument
	
    public String getPropertyKeyValue(String key) throws Throwable {
   	 FileInputStream fis = new FileInputStream("C:\\Users\\asus\\Desktop\\commondata.properties.txt");
   	 Properties pobj = new Properties();
   	 pobj.load(fis);
   	 String value = pobj.getProperty(key);
		return value;
    }

	public int getRandomNumber() {
		// TODO Auto-generated method stub
		return 0;
	}
}
