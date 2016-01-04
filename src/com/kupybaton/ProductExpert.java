package com.kupybaton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.List;
import java.sql.*;

public class ProductExpert {
	public List<Product> getProducts(List <Integer> m) {
		String URL = "jdbc:mysql://localhost:3306/kupybaton";
		String USER = "root";
		String PASS = "";
		Statement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
		List <Product> prod = new ArrayList <Product>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USER, PASS);
			stmt = conn.createStatement();
			String sql = "SELECT id, name FROM product";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				for (Integer x:m) {
					if (((Integer)rs.getInt("id")).equals(x)){
						int id = rs.getInt("id");
						String name = rs.getString("name");
						prod.add(new Product (id, name));
						}
				}
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();

		} finally {
			try {
				if(stmt!=null)
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn!=null)
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return prod;

	}
}
