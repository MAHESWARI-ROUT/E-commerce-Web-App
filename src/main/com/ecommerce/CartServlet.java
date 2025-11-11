package com.ecommerce;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class CartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @SuppressWarnings("unchecked")
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        List<Integer> cart = (List<Integer>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }

        String action = request.getParameter("action");
        String idStr = request.getParameter("id");

        if ("add".equals(action) && idStr != null) {
            cart.add(Integer.parseInt(idStr));
        } else if ("clear".equals(action)) {
            cart.clear();
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Your Cart</h2>");

        if (cart.isEmpty()) {
            out.println("<p>Cart is empty.</p>");
        } else {
            double total = 0.0;

            try (Connection conn = DBConnection.getConnection()) {
                for (int productId : cart) {
                    PreparedStatement stmt = conn.prepareStatement("SELECT name, price FROM products WHERE id=?");
                    stmt.setInt(1, productId);
                    ResultSet rs = stmt.executeQuery();

                    if (rs.next()) {
                        String name = rs.getString("name");
                        double price = rs.getDouble("price");
                        total += price;
                        out.println("<p>" + name + " - $" + price + "</p>");
                    }
                }
            } catch (SQLException e) {
                out.println("<p>Error fetching cart items: " + e.getMessage() + "</p>");
            }

            out.println("<hr><p><strong>Total: $" + total + "</strong></p>");
            out.println("<a href='checkout'>Proceed to Checkout</a><br>");
        }

        out.println("<a href='products'>Continue Shopping</a><br>");
        out.println("<a href='cart?action=clear'>Clear Cart</a>");
        out.println("</body></html>");
    }
}
