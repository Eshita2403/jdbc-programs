package jdbc_maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MobileDOA {
	String path = "com.mysql.cj.jdbc.Driver";
	Connection connection = null;
	String url = "jdbc:mysql://localhost:3306/jdbcpcr";
	String username = "root";
	String password = "root";
	
	public String insertMobileObj(Mobile mobile) {
		String query = "insert into mobile values(?,?,?,?,?,?,?)";
		try {
			Class.forName(path);
			connection = DriverManager.getConnection(url, username, password);
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, mobile.getId());
			preparedStatement.setString(2, mobile.getName());
			preparedStatement.setString(3, mobile.getBrand());
			preparedStatement.setString(4, mobile.getColor());
			preparedStatement.setDouble(5, mobile.getPrice());
			preparedStatement.setInt(6, mobile.getRam());
			preparedStatement.setString(7, mobile.getManufacturer());
			int rows = preparedStatement.executeUpdate();
			if (rows == 1) {
				return "saved";
			}

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
		return "not saved";

	}

	public String updateMobileObj(Mobile mobile) {
		String query = "UPDATE mobile SET name = ?, brand = ?, color = ?, price = ?, ram = ?, manufacture = ? WHERE (id = ?)";
		try {
			Class.forName(path);
			connection = DriverManager.getConnection(url, username, password);
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(7, mobile.getId());
			preparedStatement.setString(1, mobile.getName());
			preparedStatement.setString(2, mobile.getBrand());
			preparedStatement.setString(3, mobile.getColor());
			preparedStatement.setDouble(4, mobile.getPrice());
			preparedStatement.setInt(5, mobile.getRam());
			preparedStatement.setString(6, mobile.getManufacturer());
			int rows = preparedStatement.executeUpdate();
			if (rows == 1) {
				return "updated";
				}

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
		return "inserted";

		
		}

	public Mobile deleteMobileObj(int id) {
		String query = "delete from mobile where id =?";
		try {
			Class.forName(path);
			connection = DriverManager.getConnection(url, username, password);
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			int rows = preparedStatement.executeUpdate();
			if (rows == 1) {
				Mobile m = new Mobile();
				return m     ;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	

	public Mobile getMobileObj(int id) {
		String query = "select * from mobile where id =?";
		
		PreparedStatement preparedStatement;
		try {
			Class.forName(path);
			connection = DriverManager.getConnection(url, username, password);
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1,id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				Mobile m = new Mobile();
				
				while(resultSet.next()) {
					m.setId(resultSet.getInt(1));
					m.setName(resultSet.getString(2));
					m.setBrand(resultSet.getString(3));
					m.setColor(resultSet.getString(4));
					m.setPrice(resultSet.getInt(5));
					m.setRam(resultSet.getInt(5));
					m.setManufacturer(resultSet.getString(5));
					return m;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	
	return null;

}
}

