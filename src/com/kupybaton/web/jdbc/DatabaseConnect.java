package com.kupybaton.web.jdbc;

import java.sql.*;

public abstract class DatabaseConnect {
    private String URL = "jdbc:mysql://localhost:3306/kupybaton";
    private String USER = "root";
    private String PASS = "";

    private Connection conn;
    protected Statement stmt;
    protected PreparedStatement preparedStatement;

    protected DatabaseConnect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void closeAllDBConnections() {
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

        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() throws SQLException {
        conn = DriverManager.getConnection(URL, USER, PASS);
        return conn;
    }

    private Statement getStatement() throws SQLException {
        stmt = getConnection().createStatement();
        return stmt;
    }

    private PreparedStatement getPreparedStatement(String sql) throws SQLException {
        preparedStatement = getConnection().prepareStatement(sql);
        return preparedStatement;
    }

    protected void getPreparedStatementForCustomInsert(String sql) throws SQLException {
        getPreparedStatement(sql);
    }

    protected ResultSet getResultSet(String sql) throws SQLException {
        stmt = getStatement();
        return stmt.executeQuery(sql);
    }

    protected ResultSet getResultSetPreparedStatementById(String sql, Integer id) throws SQLException {
        preparedStatement = getPreparedStatement(sql);
        preparedStatement.setInt(1, id);
        return preparedStatement.executeQuery();
    }

}
