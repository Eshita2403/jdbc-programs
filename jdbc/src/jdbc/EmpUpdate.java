package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EmpUpdate {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String path = "com.mysql.cj.jdbc.Driver";
		Class.forName(path);
		String url ="jdbc:mysql://localhost:3306/jdbcpcr";
		String username= "root";
		String password= "root";
		Connection connection = DriverManager.getConnection(url,username , password);
		Statement st = connection.createStatement();
		
		
		st.execute("UPDATE `jdbcpcr`.`emp` SET `idemp` = '8' WHERE (`idemp` = '1')");
		st.execute("UPDATE `jdbcpcr`.`emp` SET `idemp` = '1' WHERE (`idemp` = '3')");
		st.execute("UPDATE `jdbcpcr`.`emp` SET `idemp` = '3' WHERE (`idemp` = '5')");
		
		
		connection.close();
		 System.out.println("UPDATED");
		
	}
}
