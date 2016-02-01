package com.kupybaton.web.jdbc;

import java.sql.*;

import com.kupybaton.model.KupyBaton;

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
    
    private Statement getStatement() throws SQLException {
    	conn = getConnection();
        return conn.createStatement();
    }

    private PreparedStatement getPreparedStatement(String sql) throws SQLException {
    	conn = getConnection();
        return conn.prepareStatement(sql);
    }
    
    protected PreparedStatement getPreparedStatementForCustomInsert(String sql){
    	try {
    		preparedStatement = getPreparedStatement(sql);
    	} catch (SQLException e) {
            e.printStackTrace();
        }
    	return preparedStatement;
    }
    
    protected void insertIntoDataBase(String sql, KupyBaton tableName) throws SQLException {
        preparedStatement = getPreparedStatement(sql);
        preparedStatement.setInt(1, tableName.getId());
        preparedStatement.setString(2, tableName.getName());
        preparedStatement.executeUpdate();
    }

    protected ResultSet getResultSet(String sql) throws SQLException {
        stmt = getStatement();
        return stmt.executeQuery(sql);
    }

    protected ResultSet getResultSetUsingPreparedStatement(String sql, Integer id) throws SQLException {
        preparedStatement = getPreparedStatement(sql);
        preparedStatement.setInt(1, id);
        return preparedStatement.executeQuery();
    }
   
}
