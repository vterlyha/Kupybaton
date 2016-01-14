package com.kupybaton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ListsExpert {
	public List<Product> getProducts(String tablename, String[] product_values) {
		String URL = "jdbc:mysql://localhost:3306/kupybaton";
		String USER = "root";
		String PASS = "";
		Statement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
		List<Product> prod = new ArrayList<Product>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USER, PASS);
			stmt = conn.createStatement();
			String sql = "CREATE TABLE " + tablename + "( id INT(11), name VARCHAR(60))";

			stmt.executeUpdate(sql);
			for (String one_product_value : product_values) {
				String sql2 = "INSERT INTO " + tablename + "(id, name)" + "VALUES (" + one_product_value + ")";
				stmt.executeUpdate(sql2);
			}

			String sql3 = "SELECT id, name FROM " + tablename;
			rs = stmt.executeQuery(sql3);
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				prod.add(new Product(id, name));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception ex) {
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
		return prod;

	}
}