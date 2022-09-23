package jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;



public class Driver2 {
public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
	Properties properties = new Properties();
	InputStream inputstream = new FileInputStream("jdbcproperties.properties");
	properties.load(inputstream);
	Class.forName(properties.getProperty("jdbc.path"));
	Connection connection = DriverManager.getConnection(properties.getProperty("jdbc.url"),properties.getProperty("jdbc.username"),properties.getProperty("jdbc.password"));
	System.out.println(connection);
	
}
}
