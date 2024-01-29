package Practise01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleExecuteUpdateJDBC 
{
public static void main(String[] args) throws Throwable 
{

	//Create Driver obj ref and import from MYSQL
	Driver driverRef = new Driver();
	
	//Register the Database/driver
	DriverManager.registerDriver(driverRef);
	
	//Get Connection with Database
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerDB", "root","tiger");
	
	//Issue create statement
	Statement state = conn.createStatement();
	
	//Execute a query
	//executeUpdate() is used for all non select queries - create,insert,delete,drop,update,truncate
	  int result = state.executeUpdate("insert into customer_info values(20,'Susis','Bhubaneswar');");
	  
	  if(result==1)
	  {
		  System.out.println("Data Added");
	  }
}
}
