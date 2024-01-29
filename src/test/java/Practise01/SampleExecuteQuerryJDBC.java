package Practise01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

import GenericUtilities.JavaUtilities;

public class SampleExecuteQuerryJDBC 
{
public static void main(String[] args) throws Throwable 
{
//Create Driver obj ref and import from MYSQL
	Driver driverRef = new Driver(); 
	
	//Register the Database/Driver
	DriverManager.registerDriver(driverRef);
	
	//get connection with DB
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerDB", "root", "tiger");
	
	//issue create Statement
	Statement state = conn.createStatement();
	
	//execute a query
	//executeQuery is used for select queries
	
	ResultSet result = state.executeQuery("select * from customer_info;");
	
	while(result.next())
	{    
		//System.out.println(result.getString(2));
		System.out.println(result.getInt(1)+"-"+ result.getString(2)+"-"+ result.getString(3));
	}
	//close DB
	conn.close();
	
	
	
}
}
