package com.kupybaton.web.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kupybaton.model.Category;

public class AllCategorySelectExpert {
	private static AllCategorySelectExpert allcategoryselectexpert;
	
	private AllCategorySelectExpert() {
		
	}
	
	public static AllCategorySelectExpert getAllCategorySelectExpert() {
		if (allcategoryselectexpert == null) {
			allcategoryselectexpert = new AllCategorySelectExpert();
		}
		
		return allcategoryselectexpert;
	}
	
	public List<Category> getAllCategories() {
		String URL = "jdbc:mysql://localhost:3306/kupybaton";
		String USER = "root";
		String PASS = "";
		Statement stmt = null;

		Connection conn = null;
		ResultSet categoryValues = null;

		List<Category> list = new ArrayList<Category>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USER, PASS);
			stmt = conn.createStatement();
			String sql = "SELECT * FROM category";
			categoryValues = stmt.executeQuery(sql);
			while (categoryValues.next()) {
				int category_id = categoryValues.getInt("id");
				String category_name = categoryValues.getString("name");
				list.add(new Category(category_id, category_name));
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
		return list;

	}
}

