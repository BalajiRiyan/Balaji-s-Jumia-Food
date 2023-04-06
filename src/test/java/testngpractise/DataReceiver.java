package testngpractise;

import org.testng.annotations.Test;

public class DataReceiver {
	@Test(dataProviderClass = DataPro.class,dataProvider = "provideData")
	public void getData(String un , String pwd)
	{
		System.out.println(un+" "+pwd);
	}
}
