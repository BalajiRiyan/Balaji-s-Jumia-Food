package com.genericutilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public  String readDataFromExcel(String sheetname, int rownum, int columnnum) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IpathConstants.Excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetname).getRow(rownum).getCell(columnnum).getStringCellValue();
		return value;
		
	}
	
	public void writeDataToExcel(String sheetname, int rownum, int columnnum, String data) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IpathConstants.Excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetname).getRow(rownum).getCell(columnnum).setCellValue(data);
		
		FileOutputStream fos = new FileOutputStream(IpathConstants.Excelpath);
		wb.write(fos);
		wb.close();
		
	}
	
	public HashMap<String,String> readMultipleDataFromExcel(String Sheetname) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IpathConstants.Excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(Sheetname);
		HashMap<String, String> map  = new HashMap<String, String>();
		for (int i = 0; i <= sh.getLastRowNum(); i++) {
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			 String value = sh.getRow(i).getCell(1).getStringCellValue();
			 map.put(key, value);
		}
		return map;
		
	}
	public Object[][] readSetOfDataFromExcel() throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IpathConstants.Excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("DP");
		int lastrow = sh.getLastRowNum()+1;
		int lastcell = sh.getRow(0).getLastCellNum();
		Object[][] obj = new Object[lastrow][lastcell];
		for(int i = 0;i<lastrow;i++)
		{
			for(int j = 0;j<lastcell;j++)
			{
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
				
			}
		}
		return obj;
		
		
	}
}
