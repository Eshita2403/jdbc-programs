package com.ty.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ty.dto.Cart;
import com.ty.dto.SignUp;

public class SignUpDao {
	String path = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/jdbcpcr";
	String username = "root";
	String password = "root";
	Connection con;

	public SignUp insertObj(SignUp s) {
		String query = "insert into signup values(?,?,?,?,?,?,?) ";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, s.getFirstname());
			ps.setString(2, s.getLastname());
			ps.setString(3, s.getEmail());
			ps.setString(4, s.getPassword());
			ps.setLong(5, s.getPhone());
			ps.setString(6, s.getDob());
			ps.setString(7, s.getGender());

			int rows = ps.executeUpdate();
			if (rows == 1) {
				return s;
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return null;
	}

	public SignUp updateObj(SignUp s) {
		String query = "update signup set firstname=?, lastname=?, email=?, password=?, phone=?, dob=?where gender =?";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, s.getFirstname());
			ps.setString(2, s.getLastname());
			ps.setString(3, s.getEmail());
			ps.setString(4, s.getPassword());
			ps.setLong(5, s.getPhone());
			ps.setString(6, s.getDob());
			ps.setString(7, s.getGender());

			int rows = ps.executeUpdate();
			if (rows == 1) {
				return s;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return null;
	}

	public String deleteObj(String dob) {
		String query = "delete from SignUp where dop =?";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, dob);
			int rows = ps.executeUpdate();
			if (rows == 1) {
				return dob;
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return "not deleted";
	}

	public SignUp getObj(String email, String password) {
		String query = "select * from signup  where email=? AND password =?";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, this.password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					SignUp s = new SignUp();
					s.setFirstname(rs.getString(1));
					s.setLastname(rs.getString(2));
					s.setEmail(rs.getString(3));
					s.setPassword(rs.getString(4));
					s.setPhone(rs.getLong("phone"));
					s.setDob(rs.getString(6));
					s.setGender(rs.getString(7));

					return s;
				}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return null;
	}

	public List<SignUp> getAll() {
		String query = "select * from signup";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			List<SignUp> list = new ArrayList();
			while (rs.next()) {
				SignUp s = new SignUp();

				s.setFirstname(rs.getNString(1));
				s.setLastname(rs.getString(2));
				s.setEmail(rs.getString(2));
				s.setPassword(rs.getString(4));
				s.setPhone(rs.getLong(4));
				s.setDob(rs.getString(5));
				s.setGender(rs.getString(6));

				list.add(s);
			}
			return list;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;

	}
}
