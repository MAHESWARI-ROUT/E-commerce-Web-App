package com.ecommerce;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class ProductDetailsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setCharacterEncoding("UTF-8");
        try {
            String idStr = req.getParameter("id");
            if (idStr == null) {
                res.sendRedirect("ProductServlet");
                return;
            }
            int id = Integer.parseInt(idStr);
            Product p = ProductDAO.getProductById(id);
            req.setAttribute("product", p);
            RequestDispatcher rd = req.getRequestDispatcher("ProductDetails.jsp");
            rd.forward(req, res);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
