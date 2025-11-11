package com.ecommerce;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;

public class DBTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        try (Connection conn = DBConnection.getConnection()) {
            out.println("<h3>✅ Connection Successful!</h3>");
        } catch (SQLException e) {
            out.println("<h3>❌ Connection Failed: " + e.getMessage() + "</h3>");
        }
    }
}
