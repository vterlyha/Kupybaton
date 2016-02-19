package com.kupybaton.web.jdbc.create;

import com.kupybaton.web.jdbc.DatabaseConnect;

import java.sql.SQLException;

public class UnitInserter extends DatabaseConnect {

	private static UnitInserter unitInserter;

	private UnitInserter() {
	}

	public static UnitInserter getUnitInserter() {
		if (unitInserter == null) {
			unitInserter = new UnitInserter();
		}

		return unitInserter;
	}

	public boolean insertNewUnit(String name) {
		String sql = "INSERT INTO unit (name) VALUES (?)";

		try {
			insertIntoUnit(sql, name);
            return true;
		} catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAllDBConnections();
        }
        return false;
	}

	private void insertIntoUnit(String sql, String name) throws SQLException {
        getPreparedStatementForCustomCRUD(sql);
		preparedStatement.setString(1, name);
		preparedStatement.executeUpdate();
	}
	
}