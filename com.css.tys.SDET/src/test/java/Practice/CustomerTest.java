package Practice;

import org.testng.annotations.Test;

public class CustomerTest {
	@Test(dependsOnMethods="CreateCustomerTest")
	public void CreateCustomerTest()
	{
		System.out.println("execute hdfc create customer test");
		
	}
	@Test//(invocationCount=6)
	public void ModifyCustomerTest()
	{
		System.out.println("execute hdfc modify customer test");
		
	}
	@Test
	public void DeleteCustomerTest()
	{
		System.out.println("execute hdfc delete customer test");
		
	}


}