
package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataProvideTest {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("C:\\Users\\asus\\Desktop\\Exel.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet("sheet1");
		sh.createRow(4).createCell(4).setCellValue("patil");
		FileOutputStream fos=new FileOutputStream("C:\\Users\\asus\\Desktop\\Exel.xlsx");
		book.write(fos);
		fos.flush();
		System.out.println("pass");
	}

}
