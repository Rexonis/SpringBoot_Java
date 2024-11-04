package ru.klyanchin.MyUiRestDbService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2DatabaseConnection {
    public static void main(String [] args) {
        String url = "jdbc:h2:C:/SpringBoot/MyUiRestDbService/testdb/students2"; // Изменить путь по необходимости
        String user = "";
        String password = "";
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connection to H2 database established!");
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
    }
}
