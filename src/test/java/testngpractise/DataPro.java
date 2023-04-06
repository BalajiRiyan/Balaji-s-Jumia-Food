package testngpractise;

import org.testng.annotations.DataProvider;

public class DataPro {
	
	@DataProvider
	public Object[][] provideData()
	{
		Object[][] obj = new Object[2][2] ;
		obj[0][0] = "Useername";
		obj[0][1] = "Balaji";
		obj[1][0] = "Password";
		obj[1][1] = "1234";
		return obj;
	}

}
