package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteBike {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//load and register driver
		Connection connection = null;
		String path = "com.mysql.cj.jdbc.Driver";
		try {
			Class.forName(path);
			String url ="jdbc:mysql://localhost:3306/jdbcpcr";
			String username= "root";
			String password= "root";
			connection = DriverManager.getConnection(url,username , password);
			
			String query ="delete from bike where idbike = ?";
			
			PreparedStatement ps = connection.prepareStatement(query); 
			System.out.println("enter id");
			String id = sc.next();
			ps.setString(1, id);
			ps.execute();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			 try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
//		System.out.println("enter name");
//		String name = sc.next();
//		System.out.println("enter manufacture");
//		String manufacture = sc.next();
//		System.out.println("enter milage");
//		String milage = sc.next();
//		System.out.println("enter address");
//		String address = sc.next();
//		System.out.println("enter model");
//		String model = sc.next();
		
//		ps.setString(2, name);
//		ps.setString(3, manufacture);
//		ps.setString(4, milage);
//		ps.setString(5, address);
//		ps.setString(6, model);
		
		
		
		
		 System.out.println("saved");
			
		
	}
}
