package testngpractise;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {
	@DataProvider
	public Object[][] getJob()
	{
		Object[][] data = new Object[3][3];
		data[0][0] = "Qspider";
		data[0][1] = 6;
		data[0][2] = "No Salary";
		data[1][0] = "Testyantra";
		data[1][1] = 3;
		data[1][2] = "No Salary";
		data[2][0] = "Sony";
		data[2][1] = 1;
		data[2][2] = "4.5LPA";
		return data;
	}
	@Test(dataProvider = "getJob")
	public void testJob(String place,int duration,String Salary)
	{
      Reporter.log(place+" "+duration+" "+Salary);
    }
}
