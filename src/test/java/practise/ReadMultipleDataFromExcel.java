package practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Hotel.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int count = wb.getSheet("Jumia").getLastRowNum();
		for(int i = 1;i<=count;i++) {
			String hotel = wb.getSheet("Jumia").getRow(i).getCell(0).getStringCellValue();
			String Location = wb.getSheet("Jumia").getRow(i).getCell(1).getStringCellValue();
			System.out.println(hotel+"   "+Location);
		}
		wb.close();
	}

}
