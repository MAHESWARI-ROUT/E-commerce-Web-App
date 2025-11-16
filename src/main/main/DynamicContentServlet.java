package main;

import java.io.*;
import java.time.LocalTime;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class DynamicContentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get parameters from URL
        String username = request.getParameter("username");
        String color = request.getParameter("color");

        if (username == null) username = "Guest";
        if (color == null) color = "black";

        // Generate dynamic greeting based on time
        LocalTime time = LocalTime.now();
        String greeting;
        if (time.isBefore(LocalTime.NOON)) {
            greeting = "Good Morning";
        } else if (time.isBefore(LocalTime.of(17, 0))) {
            greeting = "Good Afternoon";
        } else {
            greeting = "Good Evening";
        }

        out.println("<html><body style='background-color:" + color + "; color:white; text-align:center;'>");
        out.println("<h2>" + greeting + ", " + username + "!</h2>");
        out.println("<p>Dynamic background color: <b>" + color + "</b></p>");
        out.println("<p>Server Time: " + time + "</p>");
        out.println("</body></html>");
    }
}
