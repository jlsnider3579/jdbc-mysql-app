package com.pluralsight.dao;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConfig {
    private static BasicDataSource dataSource;

    public static BasicDataSource getDataSource(String url, String userName, String password) {
        if (dataSource == null){
            dataSource = new BasicDataSource();
            dataSource.setUrl(url);
            dataSource.setUsername(userName);
            dataSource.setPassword(password);
        }
        return dataSource;
    }

    public static Connection getConnection(String url, String userName, String password) throws SQLException {
        return getDataSource(url, userName, password).getConnection();
    }
}
