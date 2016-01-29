package com.kupybaton.web.jdbc;

import com.kupybaton.model.ProductList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GetListById {

	private static GetListById getListById;

	private GetListById() {

	}

	public static GetListById getGetListById() {
		if (getListById == null) {
			getListById = new GetListById();
		}

		return getListById;
	}

	public List<ProductList> getList(String listId) {

		String URL = "jdbc:mysql://localhost:3306/kupybaton";
		String USER = "root";
		String PASS = "";
		Statement stmt = null;
		Connection conn = null;
		ResultSet listValues = null;
		List<ProductList> list = new ArrayList<ProductList>();


		try {
			Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(URL, USER, PASS);
			stmt = conn.createStatement();
			String sql = "SELECT * FROM list WHERE id = " + listId;

            listValues = stmt.executeQuery(sql);

            while (listValues.next()) {
				Integer id = listValues.getInt("id");
				String name = listValues.getString("name");
				String dateCreated = listValues.getString("date_cr");
				String dateDeleted = listValues.getString("date_del");

//                list.add(new ProductList(id, name, dateCreated, dateDeleted));
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
