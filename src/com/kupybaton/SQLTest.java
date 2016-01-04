package com.kupybaton;

import java.sql.*;

public class SQLTest {

	public static void main(String[] args) {
		String URL = "jdbc:mysql://localhost:3306/university";
		String USER = "root";
		String PASS = "";
		Statement stmt = null;
		Connection conn = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USER, PASS);
			stmt = conn.createStatement();
			String sql = "SELECT id, first_name, last_name FROM students WHERE first_name='Vova'";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				String first = rs.getString("first_name");
				String last = rs.getString("last_name");

				System.out.print("ID: " + id);
				System.out.print(", First name: " + first);
				System.out.println(", Last name: " + last);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();

		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}
}
            
     