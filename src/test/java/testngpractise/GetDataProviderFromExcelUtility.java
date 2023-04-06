package testngpractise;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.genericutilities.ExcelUtility;

public class GetDataProviderFromExcelUtility {
	@DataProvider
	public Object[][] readSetOfDataFromExcel() throws EncryptedDocumentException, IOException
	{
		ExcelUtility eu = new ExcelUtility();
		Object[][] value = eu.readSetOfDataFromExcel();
		return value;
	}
	@Test(dataProvider = "readSetOfDataFromExcel")
	public void getData(String name,String place)
	{
		System.out.println(name+" "+place);
	}


}
