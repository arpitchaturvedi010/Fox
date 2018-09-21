package fox.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Support extends FoxTest {
	
   
	public static void writeData(String string) throws EncryptedDocumentException, IOException {
		File src=new File("E:\\sujithwp\\Fox-Automation\\Data.xlsx");
		
		FileInputStream fis=new FileInputStream(src);
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		XSSFSheet sheet1=wb.getSheetAt(0);
		
		sheet1.getRow(1).createCell(0).setCellValue(string);

		FileOutputStream fout= new FileOutputStream(src);
		wb.write(fout);
		wb.close();
	 
	}
}

