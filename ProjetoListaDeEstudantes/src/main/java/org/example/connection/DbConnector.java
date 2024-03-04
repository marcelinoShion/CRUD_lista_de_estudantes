package org.example.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {
    public static Connection getConnection() throws SQLException {
        String url ="jdbc:postgresql://localhost:5432/college";
        String user = "postgres";
        String password = "postgres";
        return DriverManager.getConnection(url,user,password);
    }
}
