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
@WebServlet(name = "English",value = "/english")
public class EnglishServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "English";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<a href=\"index.jsp\">Home</a>");
        out.println("<a href=\"studentsEnglish\">Students</a>");
        out.println("<a href=\"teacherEnglish\">Teacher</a>");
        out.println("<a href=\"tasksEnglish\">Tasks</a>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}
