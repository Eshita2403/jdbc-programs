package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateStu {
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
		
		 st.execute("UPDATE student SET id =7  where id = 3");
		 st.execute("UPDATE student SET id =8  where id = 6");
		 st.execute("UPDATE student SET id =9  where id = 4");
		 
		 // close connection/driver
		 connection.close();
		
		 System.out.println("updated");
}
}
