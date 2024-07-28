package com.example.contactproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OracleDatabase {
    private static OracleDatabase OracleDatabase = new OracleDatabase();
    private Connection connection;

    private OracleDatabase() {
        try {
            String url = "jdbc:oracle:thin:@localhost:1521:Oracle";
            String username = "contacts";
            String password = "123";
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static PreparedStatement getPreparedStatement(String sql) throws SQLException {
        return OracleDatabase.connection.prepareStatement(sql);
    }
}

