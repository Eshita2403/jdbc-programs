package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RetrieveEmp {
	public static void main(String[] args) {
		try {
			String path = "com.mysql.cj.jdbc.Driver";
			Class.forName(path);
			String url ="jdbc:mysql://localhost:3306/jdbcpcr";
			String username= "root";
			String password= "root";
			Connection con = DriverManager.getConnection(url,username , password);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from emp where empfloor =2");
			while(rs.next()) {
				System.out.println(rs.getLong(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getLong(3));
				System.out.println(rs.getString(4));
				System.out.println(rs.getString(5));
				System.out.println(rs.getString(6));
				System.out.println(rs.getInt(7));
				System.out.println(rs.getString(8));
				System.out.println("==========================");
			}
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}}
