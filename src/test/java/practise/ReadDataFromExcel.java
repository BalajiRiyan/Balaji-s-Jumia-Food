package practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
    FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Hotel.xlsx");
    Workbook wb = WorkbookFactory.create(fis);
   String data = wb.getSheet("Jumia").getRow(2).getCell(0).getStringCellValue();
   System.out.println(data);
   wb.close();
	}

}
