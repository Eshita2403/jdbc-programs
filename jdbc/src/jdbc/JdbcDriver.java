package jdbc;

import java.sql.Connection;         
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class JdbcDriver {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	//load and register driver
	String path = "com.mysql.cj.jdbc.Driver";
	Class.forName(path);
	//establish connection
	String url ="jdbc:mysql://localhost:3306/jdbcpcr";
	String username= "root";
	String password= "root";
	Connection connection = DriverManager.getConnection(url,username , password);
	//create statement
	 Statement st = connection.createStatement();
	 //procees /and execute query
	st.execute("INSERT INTO emp VALUES(4,'SANDESH') ");
	 // close connection/driver
	 connection.close();
	 System.out.println("saved");
		
	
}
}
    