package jdbc_maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	String path = "com.mysql.cj.jdbc.Driver";
	Connection connection = null;
	String url = "jdbc:mysql://localhost:3306/jdbcpcr";
	String username = "root";
	String password = "root";

	public String savedPerson(int id, String name, String address, long phone, int pin) {
		String query = "insert into person values(?,?,?,?,?)";
		try {
			Class.forName(path);
			connection = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, address);
			ps.setLong(4, phone);
			ps.setInt(5, pin);
			int rows = ps.executeUpdate();
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
	
	public String savedPersonObj(Person p) {
		String query = "insert into person values(?,?,?,?,?)";
		try {
			Class.forName(path);
			connection = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, p.getId());
			ps.setString(2, p.getName());
			ps.setString(3, p.getAddress());
			ps.setLong(4, p.getPhone());
			ps.setInt(5, p.getPin());
			int rows = ps.executeUpdate();
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
	

	public String updatePerson(int id, String name, String address, long phone, int pin) {
		String query = "UPDATE person SET name = ?, Address = ?, phone = ?, pin = ? WHERE (id = ?)";
		try {
			Class.forName(path);
			connection = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(5, id);
			ps.setString(1, name);
			ps.setString(2, address);
			ps.setLong(3, phone);
			ps.setInt(4, pin);
			int rows = ps.executeUpdate();
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
	public String updatePersonObj(Person p) {
		String query = "UPDATE person SET name = ?, Address = ?, phone = ?, pin = ? WHERE (id = ?)";
		try {
			Class.forName(path);
			connection = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(5, p.getId());
			ps.setString(1, p.getName());
			ps.setString(2, p.getAddress());
			ps.setLong(3, p.getPhone());
			ps.setInt(4, p.getPin());
			int rows = ps.executeUpdate();
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

	public String deletePerson(int id) {

		String query = "delete from person where id =?";
		try {
			Class.forName(path);
			connection = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			int rows = ps.executeUpdate();
			if (rows == 1) {
				return "deleted";
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
		return "not deleted";
	}

	public String getPerson(int id) {

		String query = "select * from person where id =?";
		
			PreparedStatement ps;
			try {
				Class.forName(path);
				connection = DriverManager.getConnection(url, username, password);
				ps = connection.prepareStatement(query);
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				if (rs != null) {
					while(rs.next()) {
						System.out.println(rs.getInt(1));
						System.out.println(rs.getString(2));
						System.out.println(rs.getString(3));
						System.out.println(rs.getLong(4));
						System.out.println(rs.getInt(5));
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

		
		return "person not present";

	}
	public Person getPersonObj(int id) {

		String query = "select * from person where id =?";
		
			PreparedStatement ps;
			try {
				Class.forName(path);
				connection = DriverManager.getConnection(url, username, password);
				ps = connection.prepareStatement(query);
				ps.setInt(1,id);
				ResultSet rs = ps.executeQuery();
				if (rs != null) {
					Person p =new Person();
					while(rs.next()) {
						p.setId(rs.getInt(1));
						p.setName(rs.getString(2));
						p.setAddress(rs.getString(3));
						p.setPhone(rs.getLong(4));
						p.setPin(rs.getInt(5));
						return p;
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
