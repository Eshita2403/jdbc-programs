package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PrepareStatement {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		//load and register driver
		String path = "com.mysql.cj.jdbc.Driver";
		Class.forName(path);
		//establish connection
		String url ="jdbc:mysql://localhost:3306/jdbcpcr";
		String username= "root";
		String password= "root";
		Connection connection = DriverManager.getConnection(url,username , password);
		//create statement
		// Statement st = connection.createStatement();
		 //procees /and execute query
		//st.execute("INSERT INTO bike VALUES(1,avenger,abc,120cc,bangalore,123) ");
		String query ="INSERT INTO bike VALUES(?,?,?,?,?,?)";
		
		PreparedStatement ps = connection.prepareStatement(query); 
		System.out.println("enter id");
		String id = sc.next();
		System.out.println("enter name");
		String name = sc.next();
		System.out.println("enter manufacture");
		String manufacture = sc.next();
		System.out.println("enter milage");
		String milage = sc.next();
		System.out.println("enter address");
		String address = sc.next();
		System.out.println("enter model");
		String model = sc.next();
		ps.setString(1, id);
		ps.setString(2, name);
		ps.setString(3, manufacture);
		ps.setString(4, milage);
		ps.setString(5, address);
		ps.setString(6, model);
		
		ps.execute();
		 // close connection/driver
		 connection.close();
		 System.out.println("saved");
			
		
	}
}
