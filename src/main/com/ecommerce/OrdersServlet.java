package com.ecommerce;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;

public class OrdersServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        try {
            List<OrderSummary> summaries = OrderSummaryDAO.getAllSummaries();
            req.setAttribute("orders", summaries);
            RequestDispatcher rd = req.getRequestDispatcher("Orders.jsp");
            rd.forward(req, res);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
