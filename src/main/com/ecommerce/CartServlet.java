package com.ecommerce;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;

public class CartServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        try {
            RequestDispatcher rd = req.getRequestDispatcher("Cart.jsp");
            rd.forward(req, res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        int productId = Integer.parseInt(req.getParameter("productId"));
        int qty = Integer.parseInt(req.getParameter("quantity"));

        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO cart (product_id, quantity) VALUES (?, ?)",
                Statement.RETURN_GENERATED_KEYS
            );
            ps.setInt(1, productId);
            ps.setInt(2, qty);
            ps.executeUpdate();

            res.sendRedirect("Cart.jsp");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
