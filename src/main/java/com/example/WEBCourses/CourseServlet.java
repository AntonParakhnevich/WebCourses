package com.example.WEBCourses;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "courses", value = "/study")
public class CourseServlet extends HttpServlet {
    private String message;
    private List<String> names = new ArrayList<>();

    public void init() {
        message = "Study";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<a href=\"index.jsp\">Home</a>");
        out.println("<a href=\"math\">Math</a>");
        out.println("<a href=\"english\">English</a>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}