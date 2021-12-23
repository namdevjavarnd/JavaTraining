package com.core.phonebook.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseConnection {
	private static Connection con;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phonebook?user=root&password=root");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public PreparedStatement createPst(String query) throws SQLException {
		return con.prepareStatement(query);
	}

	public int update(PreparedStatement pst) throws SQLException {
		return pst.executeUpdate();
	}

	public ResultSet query(PreparedStatement pst) throws SQLException {
		return pst.executeQuery();
	}

	public boolean testCon() {
		if (con != null) {
			return true;
		} else
			return false;
	}
	public void closeCon() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
