package com.project.config;

import java.sql.SQLException;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;

public class DBConnectionPool {

    private static HikariDataSource ds;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            HikariConfig config = new HikariConfig();
            config.setJdbcUrl("jdbc:mysql://localhost:3306/studentlibrary");
            config.setUsername("root");
            config.setPassword("root");

            config.setMaximumPoolSize(10);

            ds = new HikariDataSource(config);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws Exception {
        return ds.getConnection();
    }
}
