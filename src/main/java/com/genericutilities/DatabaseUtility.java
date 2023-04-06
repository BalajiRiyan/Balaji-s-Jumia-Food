package com.genericutilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
	Connection con = null;
	public void connectToDB() throws SQLException {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection(IpathConstants.DBURL,IpathConstants.DBUsername,IpathConstants.DBPassword);
	
	}
	public String executeQueryAndGetData(String Query, String expData, int columnIndex) throws SQLException 
	{
		ResultSet result = con.createStatement().executeQuery(Query);
		boolean flag = false;
		while(result.next())
		{
			String actresult = result.getString(columnIndex);
			if(actresult.equalsIgnoreCase(expData))
			{
				flag = true;
				break;
			}
		}
			if(flag)
			{
				System.out.println("Data is Verified");
				return expData;
			}
			else
			{
				System.out.println("Data is not Verified");
				return "";
			}
		}
	public void closeDB() throws SQLException {
		con.close();
		System.out.println("Database connection lost");
		
	}


}
