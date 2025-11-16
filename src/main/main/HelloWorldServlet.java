package main;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;


public class HelloWorldServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2>Hello World from Servlet in VS Code!</h2>");
    }
}