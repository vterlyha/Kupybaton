package com.kupybaton.web.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kupybaton.model.Product;
import com.kupybaton.model.ProductList;
import com.kupybaton.model.Purchase;

import com.kupybaton.web.jdbc.GetProductListById;

public class GetPurchaseByListId {
	
	private static GetPurchaseByListId getPurchaseByListId;
	
	private GetPurchaseByListId() {
		
	}
	
	public static GetPurchaseByListId getGetPurchaseByListId() {
		if (getPurchaseByListId == null) {
			getPurchaseByListId = new GetPurchaseByListId();
		}
		
		return getPurchaseByListId;
	}
	
	public List <Purchase> getPurchase(String list_id) {
		String URL = "jdbc:mysql://localhost:3306/kupybaton";
		String USER = "root";
		String PASS = "";
		Statement stmt = null;
		Connection conn = null;
		ResultSet purchaseValues = null;
		List <Purchase> purchaseList = new ArrayList <Purchase>();

		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USER, PASS);
			stmt = conn.createStatement();
			String sql = "SELECT * FROM purchase WHERE list_id = " + list_id;
			stmt.executeQuery(sql);
			purchaseValues = stmt.executeQuery(sql);
			while (purchaseValues.next()) {
				int id = purchaseValues.getInt("id");
				int listId = purchaseValues.getInt("list_id");
				ProductList productList = new GetProductListById().getProductList(listId);
				int productId = purchaseValues.getInt("product_id");
				Product product = GetOneProductById.getGetOneProductById().getProduct(productId);
				Double quantity = purchaseValues.getDouble("quantity");
				Boolean flag = purchaseValues.getBoolean("flag");
				purchaseList.add(new Purchase(id, productList, product, quantity, flag));
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
		return purchaseList;
	}

}