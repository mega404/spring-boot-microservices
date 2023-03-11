package com.example.ratingsservice.dao;

import java.sql.*;


public class DatabaseInstance {

    private static DatabaseInstance instance = null;
    private static Connection connection = null;


    private static String user_name = "root";

    private static String pass = "mysql123";

    private static String url = "jdbc:mysql://localhost:3306/rating";



    private DatabaseInstance() throws SQLException {
        connection = DriverManager.getConnection(url, user_name, pass);
        connection.setAutoCommit(false);
    }

    public static DatabaseInstance getInstance() throws SQLException {
        if (instance == null){
            instance = new DatabaseInstance();
        }
        return instance;
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

}