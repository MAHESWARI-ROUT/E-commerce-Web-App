package com.ecommerce;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;

public class CartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession(true);
        @SuppressWarnings("unchecked")
        Map<Integer, Integer> cart = (Map<Integer, Integer>) session.getAttribute("cart");
        if (cart == null) {
            cart = new LinkedHashMap<>();
        }

        String idStr = req.getParameter("productId");
        String qtyStr = req.getParameter("quantity");
        if (idStr != null) {
            int id = Integer.parseInt(idStr);
            int qty = 1;
            if (qtyStr != null) {
                try { qty = Math.max(1, Integer.parseInt(qtyStr)); } catch (Exception ignored) {}
            }

            cart.put(id, cart.getOrDefault(id, 0) + qty);
            session.setAttribute("cart", cart);
        }

        res.sendRedirect("Cart.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.sendRedirect("Cart.jsp");
    }
}
