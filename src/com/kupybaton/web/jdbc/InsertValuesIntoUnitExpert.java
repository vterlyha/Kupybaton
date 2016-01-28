package com.kupybaton.web.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertValuesIntoUnitExpert {

	private static InsertValuesIntoUnitExpert insertValuesIntoUnitExpert;
	
	private InsertValuesIntoUnitExpert() {
		
	}
	
	public static InsertValuesIntoUnitExpert getInsertValuesIntoUnitExpert() {
		if (insertValuesIntoUnitExpert == null) {
			insertValuesIntoUnitExpert = new InsertValuesIntoUnitExpert();
		}
		
		return insertValuesIntoUnitExpert;
	}
	
	
	public void insertIntoUnit(String unitName) {
		String URL = "jdbc:mysql://localhost:3306/kupybaton";
		String USER = "root";
		String PASS = "";
		Statement stmt = null;
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USER, PASS);
			stmt = conn.createStatement();
			String sql = "INSERT INTO unit (name) VALUES ('" + unitName + "')";												
			stmt.executeUpdate(sql);

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

	}
}
