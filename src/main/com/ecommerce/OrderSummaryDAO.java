package com.ecommerce;

import java.sql.*;
import java.util.*;

public class OrderSummaryDAO {

    public static void insertSummary(int orderRef, String items, double total,
                                     String name, String payment) throws Exception {

        String sql = "INSERT INTO orders_summary (order_ref, items_text, total_amount, customer_name, payment_method) " +
                     "VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, orderRef);
            ps.setString(2, items);
            ps.setDouble(3, total);
            ps.setString(4, name);
            ps.setString(5, payment);

            ps.executeUpdate();
        }
    }
    public static List<OrderSummary> getAllSummaries() throws Exception {

    List<OrderSummary> list = new ArrayList<>();

    String sql = "SELECT summary_id, order_ref, items_text, total_amount, created_at, " +
                 "customer_name, payment_method FROM orders_summary ORDER BY summary_id DESC";

    try (Connection con = DBConnection.getConnection();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            OrderSummary s = new OrderSummary();
            s.setSummaryId(rs.getInt("summary_id"));
            s.setOrderRef(rs.getInt("order_ref"));
            s.setItemsText(rs.getString("items_text"));
            s.setTotalAmount(rs.getDouble("total_amount"));
            s.setCreatedAt(rs.getString("created_at"));
            s.setCustomerName(rs.getString("customer_name"));
            s.setPaymentMethod(rs.getString("payment_method"));
            list.add(s);
        }
    }

    return list;
}

}
