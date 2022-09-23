package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteStu {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
			String path = "com.mysql.cj.jdbc.Driver";
			Class.forName(path);
			String url ="jdbc:mysql://localhost:3306/jdbcpcr";
			String username= "root";
			String password= "root";
			Connection connection = DriverManager.getConnection(url,username , password);
		
		 Statement st = connection.createStatement();
		
		 st.execute("DELETE from student where id=7 ");
		 
		 connection.close();
		 System.out.println("deleted");
}
}
