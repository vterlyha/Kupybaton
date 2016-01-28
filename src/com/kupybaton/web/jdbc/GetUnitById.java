package com.kupybaton.web.jdbc;

import java.sql.*;

import com.kupybaton.model.Unit;

public class GetUnitById {
	
	private static GetUnitById getUnitById;
	
	private GetUnitById() {
		
	}
	
	public static GetUnitById getGetUnitById() {
		if (getUnitById == null) {
			getUnitById = new GetUnitById();
		}
		
		return getUnitById;
	}
	
	public Unit getUnit(Integer unit_id) {
		String URL = "jdbc:mysql://localhost:3306/kupybaton";
		String USER = "root";
		String PASS = "";
		Statement stmt = null;
		Connection conn = null;
		ResultSet listValues = null;
		Unit unit = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USER, PASS);
			stmt = conn.createStatement();
			String sql = "SELECT * FROM unit WHERE id = " + unit_id;
			stmt.executeQuery(sql);
			listValues = stmt.executeQuery(sql);
			while (listValues.next()) {
				int id = listValues.getInt("id");
				String name = listValues.getString("name");
				unit = new Unit(id, name);
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
		return unit;
	}

}