package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class CreateCapaignTest1Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("C:\\Users\\asus\\Desktop\\commondata.properties.txt");
        Properties pobj=new Properties();
        pobj.load(fis);
        String url=pobj.getProperty("url");
       String username=pobj.getProperty("username");
       String password=pobj.getProperty("password");
       System.out.println("url is "+url);
       System.out.println("username is"+username);
       System.out.println("password is "+password);
       System.setProperty("webdriver.chrome.driver", "D:\\\\Selenium\\\\chromedriver_win32\\\\chromedriver.exe");
       WebDriver driver=new ChromeDriver();
       driver.manage().window().maximize();
       //driver.manage().timeouts().implicitlyWait(Duration of seconds(10));
       driver.get(url);
       driver.findElement(By.name("user_name")).sendKeys(username);
       driver.findElement(By.name("user_password")).sendKeys(password);
       driver.findElement(By.id("submitButton")).click();
 Actions act=new Actions(driver);
 WebElement web=driver.findElement(By.xpath("//img[@src=\"themes/softed/images/menuDnArrow.gif\"]"));
 act.moveToElement(web).build().perform();
 driver.findElement(By.xpath("//a[text()='Campaigns']")).click();
 driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
 FileInputStream fis1= new FileInputStream("C:\\Users\\asus\\Desktop\\Exel.xlsx");
	Workbook book=WorkbookFactory.create(fis1);
	org.apache.poi.ss.usermodel.Sheet sh=book.getSheet("sheet1");
	String  data=sh.getRow(0).getCell(0).getStringCellValue();
Random ru=new Random();
int num=ru.nextInt(1000);
String exputcustmername="patil";
exputcustmername=exputcustmername+num;
driver.findElement(By.cssSelector("name=\"campaignname\"")).sendKeys(exputcustmername);
driver.findElement(By.xpath("//input[@accesskey=\"S\"][1]")).click();
	}
}
