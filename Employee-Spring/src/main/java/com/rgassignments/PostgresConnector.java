package com.rgassignments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnector {
    private static String JDBC_DRIVER;
    private static String DB_URL;
    private static String USER;
    private static String PASS;

    public void setJDBC_DRIVER(String jdbcDriver) {
        PostgresConnector.JDBC_DRIVER = jdbcDriver;
    }
    public void setDB_URL(String dbURL) {
        PostgresConnector.DB_URL = dbURL;
    }
    public void setUSER(String user) {
        PostgresConnector.USER = user;
    }
    public void setPASS(String pass) {
        PostgresConnector.PASS = pass;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }
}
