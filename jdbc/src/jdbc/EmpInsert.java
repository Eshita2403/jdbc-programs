package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EmpInsert {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String path = "com.mysql.cj.jdbc.Driver";
		Class.forName(path);
		String url ="jdbc:mysql://localhost:3306/jdbcpcr";
		String username= "root";
		String password= "root";
		Connection connection = DriverManager.getConnection(url,username , password);
	Statement st = connection.createStatement();
	st.execute("INSERT INTO emp VALUES(1,'AJJU',7834987645,'SOFTWARE ENGINEER','BANGALORE','JOHN',2,'A') ");
	st.execute("INSERT INTO emp VALUES(2,'SHANU',7834987645,'SOFTWARE ENGINEER','BANGALORE','SMITH',3,'B') ");
	st.execute("INSERT INTO emp VALUES(3,'SHAIVI',7834987645,'SOFTWARE ENGINEER','BANGALORE','JOHN',4,'C') ");
	st.execute("INSERT INTO emp VALUES(4,'SIMMI',7834987645,'SOFTWARE ENGINEER','BANGALORE','SMITH',1,'C') ");
	st.execute("INSERT INTO emp VALUES(5,'ESHU',7834987645,'SOFTWARE ENGINEER','BANGALORE','SMITH',2,'D') ");
	st.execute("INSERT INTO emp VALUES(6,'ABHI',7834987645,'SOFTWARE ENGINEER','BANGALORE','JOHN',3,'A') ");
	st.execute("INSERT INTO emp VALUES(7,'SURI',7834987645,'SOFTWARE ENGINEER','BANGALORE','SMITH',2,'B') ");
	
	//st.execute("INSERT INTO emp VALUES(1,'AJJU', 7000887766, 'SOFTWARE ENGINEER', 'BANGALORE','JOHN',2,'A')");
	
	connection.close();
	 System.out.println("saved");
	}
}
