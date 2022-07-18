package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadAllDataFromExcelTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis= new FileInputStream("C:\\Users\\asus\\Desktop\\Exel.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		org.apache.poi.ss.usermodel.Sheet sh=book.getSheet("sheet1");
		int lastrow=sh.getLastRowNum();
		for(int i=0;i<=lastrow;i++)
		{
			Row row=sh.getRow(i);
			for(int j=0;j<row.getLastCellNum();j++)
			{
				DataFormatter format=new DataFormatter();
				String data=format.formatCellValue(row.getCell(j));
				System.out.print(data+"\t");
			}
			System.out.println();	
		}

			}

	}
