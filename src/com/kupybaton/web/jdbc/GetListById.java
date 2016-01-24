package com.kupybaton.web.jdbc;

<<<<<<< HEAD
=======
import com.kupybaton.model.ProductList;

>>>>>>> 8df456e5d132335dfd9edce5c54280765d4351f1
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
import com.kupybaton.model.ProductList;

public class GetListById {
	public List<ProductList> getList(String list_id) {
=======
public class GetListById {
	public List<ProductList> getList(String listId) {
>>>>>>> 8df456e5d132335dfd9edce5c54280765d4351f1
		String URL = "jdbc:mysql://localhost:3306/kupybaton";
		String USER = "root";
		String PASS = "";
		Statement stmt = null;
		Connection conn = null;
		ResultSet listValues = null;
		List<ProductList> list = new ArrayList<ProductList>();
<<<<<<< HEAD
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USER, PASS);
			stmt = conn.createStatement();
			String sql = "SELECT * FROM list WHERE id = " + list_id;
			stmt.executeQuery(sql);
			listValues = stmt.executeQuery(sql);
			while (listValues.next()) {
				int id = listValues.getInt("id");
				String name = listValues.getString("name");
				String dateCr = listValues.getString("date_cr");
				String dateDel = listValues.getString("date_del");
				list.add(new ProductList(id, name, dateCr, dateDel));
=======

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

                list.add(new ProductList(id, name, dateCreated, dateDeleted));
>>>>>>> 8df456e5d132335dfd9edce5c54280765d4351f1
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
<<<<<<< HEAD
		return list;
=======

        return list;
>>>>>>> 8df456e5d132335dfd9edce5c54280765d4351f1
	}

}
