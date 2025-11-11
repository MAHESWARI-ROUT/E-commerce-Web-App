package com.ecommerce;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class OrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        List<Integer> cart = (List<Integer>) session.getAttribute("cart");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Order Confirmation</h2>");

        if (cart == null || cart.isEmpty()) {
            out.println("<p>Your cart is empty!</p>");
        } else {
            double total = 0.0;
            try (Connection conn = DBConnection.getConnection()) {
                conn.setAutoCommit(false);

                for (int id : cart) {
                    PreparedStatement ps = conn.prepareStatement("SELECT price FROM products WHERE id=?");
                    ps.setInt(1, id);
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) total += rs.getDouble("price");
                }

                PreparedStatement orderStmt = conn.prepareStatement(
                        "INSERT INTO orders (customer_name, total_amount) VALUES (?, ?)",
                        Statement.RETURN_GENERATED_KEYS);
                orderStmt.setString(1, "Guest User");
                orderStmt.setDouble(2, total);
                orderStmt.executeUpdate();

                ResultSet keys = orderStmt.getGeneratedKeys();
                keys.next();
                int orderId = keys.getInt(1);

                PreparedStatement itemStmt = conn.prepareStatement(
                        "INSERT INTO order_items (order_id, product_id) VALUES (?, ?)");
                for (int id : cart) {
                    itemStmt.setInt(1, orderId);
                    itemStmt.setInt(2, id);
                    itemStmt.addBatch();
                }
                itemStmt.executeBatch();

                conn.commit();
                cart.clear();

                out.println("<p>Order placed successfully!</p>");
                out.println("<p>Order ID: " + orderId + "</p>");
                out.println("<p>Total: $" + total + "</p>");

            } catch (SQLException e) {
                out.println("<p>Error placing order: " + e.getMessage() + "</p>");
            }
        }

        out.println("<a href='products'>Shop Again</a>");
        out.println("</body></html>");
    }
}
