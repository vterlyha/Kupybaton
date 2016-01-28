package com.kupybaton.web.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kupybaton.model.Category;
import com.kupybaton.model.Product;
import com.kupybaton.model.Unit;

public class AllProductSelectExpert {
	
	private static AllProductSelectExpert allproductselectexpert;
	
	private AllProductSelectExpert() {
		
	}
	
	public static AllProductSelectExpert getAllProductSelectExpert () {
		if (allproductselectexpert == null) {
			allproductselectexpert = new AllProductSelectExpert();
		}
		
		return allproductselectexpert;
	}
	
	public List<Product> getAllProducts() {
		String URL = "jdbc:mysql://localhost:3306/kupybaton";
		String USER = "root";
		String PASS = "";
		Statement stmt = null;

		Connection conn = null;
		ResultSet listValues = null;

		List<Product> list = new ArrayList<Product>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USER, PASS);
			stmt = conn.createStatement();
			String sql = "SELECT p.id, p.name, u.id, u.name, c.id, c.name FROM" + 
			" `product` p JOIN `unit` u ON p.unit_id = u.id" + 
			" JOIN `category` c ON c.id = p.category_id";
			listValues = stmt.executeQuery(sql);            
			while (listValues.next()) {
				int id = listValues.getInt(1);
				String product_name = listValues.getString(2);
				int unit_id = listValues.getInt(3);
				String unit_name = listValues.getString(4);
				int category_id = listValues.getInt(5);
				String category_name = listValues.getString(6);
				Unit unit = new Unit(unit_id, unit_name);
				Category category = new Category(category_id, category_name);
				list.add(new Product(id, product_name, unit, category));
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
