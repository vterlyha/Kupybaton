package com.kupybaton.web.jdbc;

import java.sql.*;

public abstract class DatabaseConnect {
    protected String URL = "jdbc:mysql://localhost:3306/kupybaton";
    protected String USER = "root";
    protected String PASS = "";

    protected Connection conn;
    protected Statement stmt;
    protected PreparedStatement preparedStatement;

    protected DatabaseConnect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    private Statement getStatement(Connection connection) throws SQLException {
        return connection.createStatement();
    }

    private PreparedStatement getPreparedStatement(Connection connection, String sql) throws SQLException {
        return connection.prepareStatement(sql);
    }

    protected ResultSet getResultSet(String sql) throws SQLException {
        conn = getConnection();
        stmt = getStatement(conn);
        return stmt.executeQuery(sql);
    }

    protected ResultSet getResultSetUsingPreparedStatement(String sql, Integer id) throws SQLException {
        conn = getConnection();
        preparedStatement = getPreparedStatement(conn, sql);
        preparedStatement.setInt(1, id);
        return preparedStatement.executeQuery();
    }
}
