package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadDataFromPropertyFileTest {

	public static void main(String[] args) throws Throwable {
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
	}

}
