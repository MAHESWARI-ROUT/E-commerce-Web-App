    package com.ecommerce;

    import jakarta.servlet.*;
    import jakarta.servlet.http.*;
    import java.io.*;
    import java.util.*;

    public class ProductServlet extends HttpServlet {
        protected void doGet(HttpServletRequest req, HttpServletResponse res)
                throws ServletException, IOException {
            res.setCharacterEncoding("UTF-8");
            try {
                List<Product> products = ProductDAO.getAllProducts();
                req.setAttribute("products", products);
                RequestDispatcher rd = req.getRequestDispatcher("ProductCatalog.jsp");
                rd.forward(req, res);
            } catch (Exception e) {
                throw new ServletException(e);
            }
        }
    }
