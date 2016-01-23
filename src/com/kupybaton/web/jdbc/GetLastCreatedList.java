package com.kupybaton.web.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kupybaton.model.ProductList;

public class GetLastCreatedList {
	public List<ProductList> getList() {
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
			String sql = "SELECT * FROM list ORDER BY id DESC LIMIT 1";
			stmt.executeQuery(sql);
			listValues = stmt.executeQuery(sql);
			while (listValues.next()) {
				int id = listValues.getInt("id");
				String name = listValues.getString("name");
				String dateCr = listValues.getString("date_cr");
				String dateDel = listValues.getString("date_del");
				list.add(new ProductList(id, name, dateCr, dateDel));
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
