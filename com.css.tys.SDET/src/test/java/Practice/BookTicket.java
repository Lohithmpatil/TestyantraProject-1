package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BookTicket {
	@Test(dataProvider="dataprovider_bookTicketTest")
	public void bookTicketTest(String src , String dst)
	{
		System.out.println("Book ticket from "+src+" to "+dst);
	}
	@DataProvider
	public Object[][] dataprovider_bookTicketTest()
	{
		Object[][] objArr=new Object[5][2];
		
		objArr[0][0]="banglore";
		objArr[0][1]="goa";
		
		objArr[1][0]="banglore";
		objArr[1][1]="mysore";
		
		objArr[2][0]="banglore";
		objArr[2][1]="manglore";
		
		objArr[3][0]="banglore";
		objArr[3][1]="hyd";
		
		objArr[4][0]="banglore";
		objArr[0][1]="mp";
		return objArr;
		
	}
	
	

}
