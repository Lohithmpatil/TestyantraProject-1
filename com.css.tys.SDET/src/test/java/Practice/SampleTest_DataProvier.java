package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SampleTest_DataProvier {
	@Test(dataProvider="dataprovider_bookTicketTest")
	public void bookTicketTest(String src , String dst , int ticket)
	{
		System.out.println("Book ticket from "+src+" to "+dst);
	}
	@DataProvider
	public Object[][] dataprovider_bookTicketTest()
	{
		Object[][] objArr=new Object[5][3];
		
		objArr[0][0]="banglore";
		objArr[0][1]="goa";
		objArr[0][2]=10;
		
		objArr[1][0]="banglore";
		objArr[1][1]="mysore";
		objArr[1][2]=10;
		
		objArr[2][0]="banglore";
		objArr[2][1]="manglore";
		objArr[2][2]=10;
		
		objArr[3][0]="banglore";
		objArr[3][1]="hyd";
		objArr[3][2]=10;
		
		objArr[4][0]="banglore";
		objArr[4][1]="mp";
		objArr[4][2]=10;
		return objArr;
		
	}
}
