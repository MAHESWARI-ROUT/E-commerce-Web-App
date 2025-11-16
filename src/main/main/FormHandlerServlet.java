package main;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;


public class FormHandlerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Fetch form data
        String name = request.getParameter("username");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");

        // Display response
        out.println("<html><body>");
        out.println("<h2>Form Submitted Successfully!</h2>");
        out.println("<p><b>Name:</b> " + name + "</p>");
        out.println("<p><b>Email:</b> " + email + "</p>");
        out.println("<p><b>Gender:</b> " + gender + "</p>");
        out.println("</body></html>");
    }
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.sendRedirect("form.jsp");
    }
}
