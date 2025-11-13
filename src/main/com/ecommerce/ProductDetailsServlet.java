package com.ecommerce;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class ProductDetailsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            Product p = ProductDAO.getProductById(id);
            req.setAttribute("product", p);
            RequestDispatcher rd = req.getRequestDispatcher("ProductDetails.jsp");
            rd.forward(req, res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
