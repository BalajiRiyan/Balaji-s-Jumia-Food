package practise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class InsertDataIntoDatabase {

	public static void main(String[] args) throws Throwable {
      Driver driver = new Driver();
      DriverManager.registerDriver(driver);
     Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TYMarch","root","root");
    // Object query =   "insert into students values(3,"Krishna","BTM",4);";
      
	}

}
