package jdbc_maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IncludingCollection {
public static void main(String[] args) {
	List <Mobile>lt = new ArrayList();
	Mobile mobile= new Mobile(2, "vivo", "djff", "nuhghj", 200, 2, "eee");
	Mobile mobile1= new Mobile(3, "ivo", "jghf", "ooooo", 300, 2, "ppp");
	
	lt.add(mobile);
	lt.add(mobile1);
	
	
	
	
	
	//jdbc code
	String path = "com.mysql.cj.jdbc.Driver";
	Connection connection = null;
	String url = "jdbc:mysql://localhost:3306/jdbcpcr";
	String username = "root";
	String password = "root";
	String query = "insert into mobile values(?,?,?,?,?,?,?)";
	try {
		Class.forName(path);
		connection = DriverManager.getConnection(url, username, password);
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		for(Mobile m : lt) {
			preparedStatement.setInt(1,m.getId());
			preparedStatement.setString(2,m.getName());
			preparedStatement.setString(3,m.getBrand());
			preparedStatement.setString(4,m.getColor());
			preparedStatement.setDouble(5,m.getPrice());
			preparedStatement.setInt(6,m.getRam());
			preparedStatement.setString(7,m.getManufacturer());
			preparedStatement.addBatch();
		}
		preparedStatement.executeBatch();  
		

	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}

	finally {
		if (connection != null)
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
		
}
}
