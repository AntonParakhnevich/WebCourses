package com.example.WEBCourses;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by .
 */
@WebServlet(name = "Math",value = "/math")
public class MathServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Math";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<a href=\"index.jsp\">Home</a>");
        out.println("<a href=\"studentsMath\">Students</a>");
        out.println("<a href=\"teacher\">Teacher</a>");
        out.println("<a href=\"tasksMath\">Tasks</a>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}
