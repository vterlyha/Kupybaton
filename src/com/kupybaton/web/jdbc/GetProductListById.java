package com.kupybaton.web.jdbc;

import com.kupybaton.model.ProductList;

import java.sql.*;


public class GetProductListById {
	public ProductList getProductList(Integer listId) {

		String URL = "jdbc:mysql://localhost:3306/kupybaton";
		String USER = "root";
		String PASS = "";
		Statement stmt = null;
		Connection conn = null;
		ResultSet listValues = null;
		ProductList productList = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(URL, USER, PASS);
			stmt = conn.createStatement();
			String sql = "SELECT * FROM list WHERE id = " + listId;

            listValues = stmt.executeQuery(sql);

            while (listValues.next()) {
				Integer id = listValues.getInt("id");
				String name = listValues.getString("name");
				String dateCreated = listValues.getString("date_cr");
				String dateDeleted = listValues.getString("date_del");
				productList = new ProductList(id, name, dateCreated, dateDeleted);
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
        return productList;

	}

}
