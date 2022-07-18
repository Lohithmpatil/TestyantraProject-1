package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDatafFromExelTest {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		FileInputStream fis= new FileInputStream("C:\\Users\\asus\\Desktop\\Exel.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		org.apache.poi.ss.usermodel.Sheet sh=book.getSheet("Sheet1");
		String  value1=sh.getRow(0).getCell(0).getStringCellValue();
		System.out.println(value1);
		double value2=sh.getRow(1).getCell(0).getNumericCellValue();
		System.out.println(value2);	
	}

}
