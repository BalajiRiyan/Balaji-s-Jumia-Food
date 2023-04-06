package practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteMultipleDataIntoExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException{
     Scanner sc = new Scanner(System.in);
     System.out.println("Enter the Number of Datas");
     int count = sc.nextInt();
     FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Hotel.xlsx");
     Workbook wb = WorkbookFactory.create(fis);
     Sheet sh = wb.createSheet("Jumia1");
     
     for(int i=0;i<=count;i++) {
    	System.out.println("Enter the Name");
    	 String Name = sc.next();
    	 sh.createRow(i).createCell(0).setCellValue(Name);
    	 System.out.println("Enter the Degree");
    	 String Degree = sc.next();
    	 sh.createRow(i).createCell(1).setCellValue(Degree);
     }
     FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\Hotel.xlsx");
     wb.write(fos);
     wb.close();
	}
}
