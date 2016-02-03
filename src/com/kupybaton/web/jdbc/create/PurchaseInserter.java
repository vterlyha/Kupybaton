package com.kupybaton.web.jdbc.create;

import com.kupybaton.web.jdbc.DatabaseConnect;

import java.sql.SQLException;

public class PurchaseInserter extends DatabaseConnect {

	private static PurchaseInserter purchaseInserter;

	private PurchaseInserter() {
	}

	public static PurchaseInserter getListInserter() {
		if (purchaseInserter == null) {
			purchaseInserter = new PurchaseInserter();
		}

		return purchaseInserter;
	}

	public boolean insertNewPurchase(String name, Integer list_id, Integer product_id, Double quantity) {
		String sql = "INSERT INTO purchase (list_id, product_id, quantity, flag) VALUES (?, ?, ?, 1)";

		try {
			insertIntoPurchase(sql, list_id, product_id, quantity);
            return true;
		} catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAllDBConnections();
        }
        return false;
	}

	private void insertIntoPurchase(String sql, Integer list_id, Integer product_id, Double quantity) throws SQLException {
        getPreparedStatementForCustomInsert(sql);
		preparedStatement.setInt(1, list_id);
		preparedStatement.setInt(2, product_id);
		preparedStatement.setDouble(3, quantity);
		preparedStatement.executeUpdate();
	}
	
}