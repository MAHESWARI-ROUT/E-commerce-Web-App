package com.ecommerce;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;

public class CheckoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        try (Connection con = DBConnection.getConnection()) {
            Statement st = con.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE, 
                ResultSet.CONCUR_READ_ONLY
            );

            ResultSet rs = st.executeQuery(
                "SELECT c.id, c.quantity, p.price FROM cart c JOIN products p ON c.product_id=p.id"
            );

            double total = 0;
            while (rs.next()) {
                total += rs.getInt("quantity") * rs.getDouble("price");
            }

            PreparedStatement psOrder = con.prepareStatement(
                "INSERT INTO orders (total) VALUES (?)", Statement.RETURN_GENERATED_KEYS
            );
            psOrder.setDouble(1, total);
            psOrder.executeUpdate();

            ResultSet orderKeys = psOrder.getGeneratedKeys();
            orderKeys.next();
            int orderId = orderKeys.getInt(1);

            rs.beforeFirst();
            rs = st.executeQuery("SELECT * FROM cart");
            while (rs.next()) {
                PreparedStatement psItem = con.prepareStatement(
                    "INSERT INTO order_items (order_id, product_id, quantity) VALUES (?, ?, ?)"
                );
                psItem.setInt(1, orderId);
                psItem.setInt(2, rs.getInt("product_id"));
                psItem.setInt(3, rs.getInt("quantity"));
                psItem.executeUpdate();
            }

            con.createStatement().execute("DELETE FROM cart");
            res.sendRedirect("OrderSuccess.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
