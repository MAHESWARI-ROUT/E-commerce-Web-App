package com.ecommerce;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;

public class CheckoutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html;charset=UTF-8");

        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("cart") == null) {
            res.sendRedirect("ProductServlet");
            return;
        }

        String name = req.getParameter("customerName");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        String paymentMethod = req.getParameter("paymentMethod");

        Map<Integer, Integer> cart = (Map<Integer, Integer>) session.getAttribute("cart");

        double grandTotal = 0.0;
        StringBuilder summaryText = new StringBuilder();

        try {
            //  total
            for (Map.Entry<Integer, Integer> e : cart.entrySet()) {
                int productId = e.getKey();
                int qty = e.getValue();
                Product p = ProductDAO.getProductById(productId);
                double line = p.getPrice() * qty;
                grandTotal += line;

                if (summaryText.length() > 0) summaryText.append(", ");
                summaryText.append(qty).append(" x ").append(p.getName());
            }

            // Insert into orders
            int orderId = OrderDAO.createOrder(
                    name, phone, address, paymentMethod, grandTotal
            );

            // Insert order items
            for (Map.Entry<Integer, Integer> e : cart.entrySet()) {
                OrderDAO.createOrderItem(orderId, e.getKey(), e.getValue());
            }

            // Save summary record
            OrderSummaryDAO.insertSummary(
                    orderId, summaryText.toString(), grandTotal, name, paymentMethod
            );

            session.removeAttribute("cart");
            res.sendRedirect("OrderSuccess.jsp");

        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }
}
