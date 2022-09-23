package jdbc_maven;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Stud {
public static void main(String[] args) {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcpcr", "root", "root");
		CallableStatement cs = con.prepareCall("call select_where(?)");
		cs.setInt(1, 10);
//		cs.setString(2, "eshi");
//		cs.setInt(3, 27272828);
//		cs.setString(4, "blr");
//		cs.setInt(5, 1233);
		
		ResultSet rs =cs.executeQuery();
		if(rs!=null) {
			while(rs.next()) {
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getLong(3));
			System.out.println(rs.getString(4));
			System.out.println(rs.getInt(5));
			System.out.println("=====================");
			}
		}
		
		con.close();
	
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
		
	
	
	
}
}
