package practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WritingDataToExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
     FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Hotel.xlsx");
     Workbook wb = WorkbookFactory.create(fis);
     wb.getSheet("Jumia").getRow(3).getCell(0).setCellValue("KFC");
     FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\Hotel.xlsx");
     wb.write(fos);
     wb.close();
	}

}
