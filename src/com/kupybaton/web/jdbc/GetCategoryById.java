package com.kupybaton.web.jdbc;

import java.sql.*;

import com.kupybaton.model.Category;

public class GetCategoryById {
	public Category getCategory(Integer category_id) {
		String URL = "jdbc:mysql://localhost:3306/kupybaton";
		String USER = "root";
		String PASS = "";
		Statement stmt = null;
		Connection conn = null;
		ResultSet categoryValues = null;
		Category category = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USER, PASS);
			stmt = conn.createStatement();
			String sql = "SELECT * FROM unit WHERE id = " + category_id;
			stmt.executeQuery(sql);
			categoryValues = stmt.executeQuery(sql);
			while (categoryValues.next()) {
				int id = categoryValues.getInt("id");
				String name = categoryValues.getString("name");
				category = new Category(id, name);
			}

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
		return category;
	}

}