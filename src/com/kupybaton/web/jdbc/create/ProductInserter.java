package com.kupybaton.web.jdbc.create;

import com.kupybaton.web.jdbc.DatabaseConnect;

import java.sql.SQLException;

public class ProductInserter extends DatabaseConnect {

	private static ProductInserter productInserter;

	private ProductInserter() {
	}

	public static ProductInserter getListInserter() {
		if (productInserter == null) {
			productInserter = new ProductInserter();
		}

		return productInserter;
	}

	public boolean insertNewProduct(String name, Integer category_id, Integer unit_id) {
		String sql = "INSERT INTO product (name, category_id, unit_id) VALUES (?, ?, ?)";

		try {
			insertIntoProduct(sql, name, category_id, unit_id);
            return true;
		} catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAllDBConnections();
        }
        return false;
	}

	private void insertIntoProduct(String sql, String name, Integer category_id, Integer unit_id) throws SQLException {
        getPreparedStatementForCustomInsert(sql);
		preparedStatement.setString(1, name);
		preparedStatement.setInt(2, category_id);
		preparedStatement.setInt(3, unit_id);
		preparedStatement.executeUpdate();
	}
	
}