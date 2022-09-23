package jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

public class RetrieveStu {
public static void main(String[] args) throws IOException {
	try {
		Properties properties = new Properties();
		InputStream inputstream = new FileInputStream("jdbcproperties.properties");
		properties.load(inputstream);
		Class.forName(properties.getProperty("jdbc.path"));
		Connection con = DriverManager.getConnection(properties.getProperty("jdbc.url"),properties.getProperty("jdbc.username"),properties.getProperty("jdbc.password"));
		//Connection con2= DriverManager.get
		Statement st = con.createStatement();
		String query = "select * from student";
		ResultSet rs = st.executeQuery(query);
		
		while(rs.next()) {
			System.out.println(rs.getLong(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getLong(3));
			System.out.println(rs.getString(4));
			System.out.println(rs.getLong(5));
			System.out.println("==========================");
		}
		st.close();
		con.close();
		
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
}
}
  