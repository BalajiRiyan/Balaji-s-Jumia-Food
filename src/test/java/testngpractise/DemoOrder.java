package testngpractise;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class DemoOrder {
	@Test(priority = 1,invocationCount = 1)
	public void createOrder()
	{
		Reporter.log("Order Created",true);
	}
	@Test(priority = 3,invocationCount =1,dependsOnMethods = "createOrder")
	public void viewOrder()
	{
		Reporter.log("Your Ordered list",true);
	}
	@Test(priority = 2,dependsOnMethods = "createOrder")
	public void updateOrder()
	{
		Reporter.log("Order Updated",true);
	}
	@Test(priority = 4,dependsOnMethods = {"createOrder","updateOrder"})
	public void deleteOrder()
	{
		Reporter.log("Order Updated",true);
	}

}
