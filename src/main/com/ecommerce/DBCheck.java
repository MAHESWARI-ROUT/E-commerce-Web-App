package com.ecommerce;

import java.sql.Connection;
import java.sql.SQLException;

public class DBCheck {
    public static void main(String[] args) {
        try (Connection conn = DBConnection.getConnection()) {
            if (conn != null) {
                System.out.println("✅ Database connection successful!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
