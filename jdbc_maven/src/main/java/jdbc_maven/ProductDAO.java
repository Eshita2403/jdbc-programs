package jdbc_maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class ProductDAO {
	String path ="com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/jdbcpcr";
	String username = "root";
	String password = "root";
	Connection connection = null;
	
	
	public Product insertProduct(Product p) {
		String query = "insert into product values(?,?,?,?,?,?,?,?)";
		
		try {
			Class.forName(path);
			connection=DriverManager.getConnection(url, username, password);
			PreparedStatement ps = connection.prepareStatement(query);
	
			ps.setInt(1, p.getProductid());
			ps.setString(2, p.getName());
			ps.setDouble(3, p.getPrice());
			ps.setString(4, p.getManufacture());
			ps.setDouble(5, p.getDiscount());
			ps.setString(6, p.getWarranty());
			ps.setString(7, p.getMfd());
			ps.setDouble(8, p.getGst());
			int rows =ps.executeUpdate();
			if(rows==1) {
				return p;
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		}
		
		return null;
		
	}
	public Product updateProduct(Product p) {
String query = "UPDATE product SET name = ?, price = ?, manufacture = ?, discount = ?, warranty = ?, mfd = ?, gst = ? WHERE productid = ?";
		
		 {
			try {
				Class.forName(path);
				connection=DriverManager.getConnection(url, username, password);
				PreparedStatement ps = connection.prepareStatement(query);
				
				ps.setInt(8, p.getProductid());
				ps.setString(1, p.getName());
				ps.setDouble(2, p.getPrice());
				ps.setString(3, p.getManufacture());
				ps.setDouble(4, p.getDiscount());
				ps.setString(5, p.getWarranty());
				ps.setString(6, p.getMfd());
				ps.setDouble(7, p.getGst());
				int rows =ps.executeUpdate();
				if(rows==1) {
					return p;
				}
				
				
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (SQLException e) {
	
				e.printStackTrace();
			}
			finally {
				if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
			}
			
		}}
		return null;
		
		
	}
	public String deleteProduct(int id) {
		String query= "DELETE FROM `jdbcpcr`.`product` WHERE (`productid` = ?);";
		try {
			Class.forName(path);
			connection = DriverManager.getConnection(url,username,password);
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			int rows = ps.executeUpdate();
			if(rows==1) {
				return "product deleted";
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
			}
		
		return "product not deleted";
		
	}
	public Product getProduct(int id) {
		String query = "select * from product where productid =?";
		try {
			Class.forName(path);
			connection = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs!=null) {
				Product p = new Product();
				while(rs.next()) {
					p.setProductid(rs.getInt(1));
					p.setName(rs.getString(2));
					p.setPrice(rs.getDouble(3));
					p.setManufacture(rs.getString(4));
					p.setDiscount(rs.getDouble(5));
					p.setWarranty(rs.getString(6));
					p.setMfd(rs.getString(7));
					p.setGst(rs.getDouble(8));
					
				}
				return p;		
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
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
	public List<Product> getAllProduct(){
		String query = "select * from product";
		try {
			Class.forName(path);
			connection = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			List<Product> list = new ArrayList();
			while(rs.next()) {
				Product p = new Product();
			
				p.setProductid(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setPrice(rs.getDouble(3));
				p.setManufacture(rs.getString(4));
				p.setDiscount(rs.getDouble(5));
				p.setWarranty(rs.getString(6));
				p.setMfd(rs.getString(7));
				p.setGst(rs.getDouble(8));
				list.add(p);
			}
		return list;
		
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
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
}
