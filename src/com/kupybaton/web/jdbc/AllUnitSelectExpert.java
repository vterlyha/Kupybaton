package com.kupybaton.web.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kupybaton.model.Unit;

public class AllUnitSelectExpert {
	public List<Unit> getAllUnits() {
		String URL = "jdbc:mysql://localhost:3306/kupybaton";
		String USER = "root";
		String PASS = "";
		Statement stmt = null;

		Connection conn = null;
		ResultSet unitValues = null;

		List<Unit> list = new ArrayList<Unit>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USER, PASS);
			stmt = conn.createStatement();
			String sql = "SELECT * FROM unit";
			unitValues = stmt.executeQuery(sql);
			while (unitValues.next()) {
				int unit_id = unitValues.getInt("id");
				String unit_name = unitValues.getString("name");
				list.add(new Unit(unit_id, unit_name));
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

