package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;


public class BrowserLaunchTest {

	public static void main(String[] args) throws Throwable{
		Connection conn=null;
		try {
		Driver driverRef=new Driver();
	
    //Register to the database
          DriverManager.registerDriver(driverRef);
    //connect to the database
         conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
         System.out.println("connection is done");
    //create a query statement
         Statement stat= conn.createStatement();
         String query= "select * from students_info";
    //execute the query
          ResultSet resultset= stat.executeQuery(query);
           while(resultset.next());
   {
	   System.out.println(resultset.getString(1) +"\t"+resultset.getString(2)+"\t"+resultset.getString(3)+"\t"+resultset.getString(4));
   }
		}
   catch(Exception e) {
   }
   finally
   {
	   conn.close();
	   System.out.println("====close db connection=====");
   }
}
	}
    
    

