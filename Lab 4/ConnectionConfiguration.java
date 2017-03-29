package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by usmannoor on 15/03/2017.
 */
public class ConnectionConfiguration {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql//localhost:3306/test","root","1234");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
