package com.kupybaton.web.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kupybaton.model.Product;
import com.kupybaton.model.Unit;
import com.kupybaton.model.Category;

import com.kupybaton.web.jdbc.GetUnitById;

public class GetFirstProduct {
	
	private static GetFirstProduct getFirstProduct;
	
	private GetFirstProduct() {
		
	}
	
	public static GetFirstProduct getGetFirstProduct() {
		if (getFirstProduct == null) {
			getFirstProduct = new GetFirstProduct();
		}
		
		return getFirstProduct;
	}
	
	public List <Product> getProduct(Integer product_id) {
		String URL = "jdbc:mysql://localhost:3306/kupybaton";
		String USER = "root";
		String PASS = "";
		Statement stmt = null;
		Connection conn = null;
		ResultSet productValues = null;
		List <Product> list = new ArrayList<Product>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USER, PASS);
			stmt = conn.createStatement();
			String sql = "SELECT * FROM product WHERE id = " + product_id;
			stmt.executeQuery(sql);
			productValues = stmt.executeQuery(sql);
			while (productValues.next()) {
				int id = productValues.getInt("id");
				String name = productValues.getString("name");
				int unit_id = productValues.getInt("unit_id");
				Unit unit = GetUnitById.getGetUnitById().getUnit(unit_id);
				int category_id = productValues.getInt("category_id");
				Category category = GetCategoryById.getGetCategoryById().getCategory(category_id);
				list.add(new Product(id, name, unit, category));
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