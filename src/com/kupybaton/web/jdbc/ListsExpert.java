package com.kupybaton.web.jdbc;

import com.kupybaton.model.ProductList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ListsExpert {
	public List<ProductList> getProducts(String tablename, String[] product_values) {
		String URL = "jdbc:mysql://localhost:3306/kupybaton";
		String USER = "root";
		String PASS = "";
		Statement stmt = null;
		Connection conn = null;
		ResultSet listValues = null;
		List<ProductList> list = new ArrayList<ProductList>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USER, PASS);
			stmt = conn.createStatement();
            String sql = "SELECT id, name FROM list WHERE date_del IS NULL";
            listValues = stmt.executeQuery(sql);
			while (listValues.next()) {
				int id = listValues.getInt("id");
				String name = listValues.getString("name");
				list.add(new ProductList(id, name));
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
		return list;

	}
}
