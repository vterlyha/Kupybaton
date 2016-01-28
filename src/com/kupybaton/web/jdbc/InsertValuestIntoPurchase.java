package com.kupybaton.web.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertValuestIntoPurchase {
	
	private static InsertValuestIntoPurchase insertValuesIntoPurchase;
	
	private InsertValuestIntoPurchase() {
		
	}
	
	public static InsertValuestIntoPurchase getInsertValuestIntoPurchase() {
		if (insertValuesIntoPurchase == null) {
			insertValuesIntoPurchase = new InsertValuestIntoPurchase();
		}
		
		return insertValuesIntoPurchase;
	}
	
	public void insertIntoPurchase(String listId, Integer productId, String quantity) {
		String URL = "jdbc:mysql://localhost:3306/kupybaton";
		String USER = "root";
		String PASS = "";
		Statement stmt = null;
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USER, PASS);
			stmt = conn.createStatement();
			String sql = "INSERT INTO purchase (list_id, product_id, quantity, flag) VALUES ( " + listId + ", " + productId + ", " + quantity + ", 1)";												
			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}
}
