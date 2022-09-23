package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String path = "com.mysql.cj.jdbc.Driver";
		Class.forName(path);
		String url ="jdbc:mysql://localhost:3306/jdbcpcr";
		String username= "root";
		String password= "root";
		Connection connection = DriverManager.getConnection(url,username , password);
		
		 Statement st = connection.createStatement();
		 
		 st.execute("INSERT INTO student VALUES(1,'AJJU',7834987645,'BANGALORE',123456) ");
		 st.execute("INSERT INTO student VALUES(2,'NAGU',7000987645,'BANGALORE',123456) ");
		 st.execute("INSERT INTO student VALUES(3,'SHAINI',7090909645,'BANGALORE',123456) ");
		 st.execute("INSERT INTO student VALUES(4,'RAJJU',7800000045,'BANGALORE',123456) ");
		 st.execute("INSERT INTO student VALUES(5,'ESHU',7807182429,'BANGALORE',123456) ");
		 st.execute("INSERT INTO student VALUES(6,'SANDY',7802234429,'BANGALORE',123456) ");
		 st.execute("INSERT INTO student VALUES(7,'ASH',7808882429,'BANGALORE',123456) ");
		 
		 connection.close();
		 System.out.println("saved");
}
}